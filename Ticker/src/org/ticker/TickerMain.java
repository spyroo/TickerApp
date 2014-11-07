package org.ticker;

import java.util.Scanner;

public class TickerMain {

	public static void main(String[] args) {
		new TickerMain();
	}

	public TickerMain() {
		System.out.println("Starting ticker app...");
		TickerFileReader tfr = new TickerFileReader();
		MatchupList ml = tfr.getMatchupList();
		System.out.println(ml.getTickerText());
		tfr.writeToTicker(ml.getTickerText());

		Scanner sc = new Scanner(System.in);
		String line;
		while ((line = sc.nextLine()) != null) {
			String[] cmdpts = line.split(" ");
			if (cmdpts[0].contains("add")) {
				for (Matchup m : ml.getMatchupArrayList()) {
					if (m.incScore(cmdpts[1])) {
						System.out.println("Added a point to team " + cmdpts[1]);
						rewriteTicker(tfr, ml);
					}
				}
			}
		}

	}

	public void rewriteTicker(TickerFileReader tfr, MatchupList ml) {
		tfr.writeToTicker(ml.getTickerText());
		System.out.println(ml.getTickerText());
	}

}

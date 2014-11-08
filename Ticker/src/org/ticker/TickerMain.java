package org.ticker;

public class TickerMain {

	public static void main(String[] args) {
		new TickerMain();
	}

	public TickerMain() {
		System.out.println("Starting program and fetching scores...");
		ScoreboardCreator scores = new ScoreboardCreator();
		TickerFileReader tfr = new TickerFileReader();
		System.out.println("Started!");
		while (true) {
			try {
				tfr.writeToScoreboard("Current scores in NA Platinum");
				Thread.currentThread().sleep(6000);
				int pos = 1;
				for (Team s : scores.getTeams()) {
					String out = "#" + pos++ + ": " + s.getName() + " W" + s.getWins() + " L" + s.getLosses();
					System.out.println("\t" + out);
					tfr.writeToScoreboard(out);
					Thread.currentThread().sleep(4000);

				}
				tfr.writeToScoreboard("");
				scores.rereadTeams();
				System.out.println("Next update in 300000 milliseconds");
				Thread.currentThread().sleep(300000);
			} catch (Exception e) {

			}
		}

	}

	public void rewriteTicker(TickerFileReader tfr, MatchupList ml) {
		tfr.writeToTicker(ml.getTickerText());
		System.out.println(ml.getTickerText());
	}

}

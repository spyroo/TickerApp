package org.ticker;

public class TickerMain {
	
	
	public static void main(String[] args){
		new TickerMain();
	}
	
	public TickerMain(){
		System.out.println("Starting ticker app...");
		TickerFileReader tfr = new TickerFileReader();
		MatchupList ml = tfr.getMatchupList();
		System.out.println(ml.getTickerText());
		
	}
	
	
}

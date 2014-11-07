package org.ticker;

import java.util.ArrayList;

public class MatchupList {
	
	private ArrayList<Matchup> matchups;
	
	public MatchupList(){
		matchups = new ArrayList<Matchup>();
	}
	
	public void addMatchup(Matchup matchup){
		matchups.add(matchup);
	}
	
	public String getTickerText(){
		String temp = "";
		for(Matchup m : matchups){
			temp += m.getFormattedScores();
		}
		return temp;
	}
	
	public ArrayList<Matchup> getMatchupArrayList(){
		return matchups;
	}
	
}

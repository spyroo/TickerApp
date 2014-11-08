package org.ticker;

import java.util.ArrayList;

import org.ticker.webreader.WebReader;

public class ScoreboardCreator {
	
	public static final String PLAT_URL_CURRENT_SEASON = "http://www.ugcleague.com/rankings_tf2h_currentseason.cfm?division=47";
	private ArrayList<Team> teams;
	
	public ScoreboardCreator(){
		teams = new ArrayList<Team>();
		populateTeams(WebReader.getUrlSource(PLAT_URL_CURRENT_SEASON));
		System.out.println(teams);
	}
	
	private void populateTeams(ArrayList<String> unparsedSite){
		for(int i = 0; i < unparsedSite.size(); i++){
			String s = unparsedSite.get(i);
			if(s.contains("title") && s.contains("</a>") && !s.contains("tooltip")){
				try{
					String teamTag = cleanInput(s);
					String name = cleanInput(unparsedSite.get(i+1));
					int wins = Integer.parseInt(cleanInput(unparsedSite.get(i+2)));
					int losses = Integer.parseInt(cleanInput(unparsedSite.get(i+3)));
					double mp = Double.parseDouble(cleanInput(unparsedSite.get(i+4)));
					int plusMinus = Integer.parseInt(cleanInput(unparsedSite.get(i+5)));
					double winPercent = Double.parseDouble(cleanInput(unparsedSite.get(i+6)));
					int pointsFor = Integer.parseInt(cleanInput(unparsedSite.get(i+7)));
					int pointsAgainst = Integer.parseInt(cleanInput(unparsedSite.get(i+8)));
					int pointsDiff = Integer.parseInt(cleanInput(unparsedSite.get(i+9)));
					int gamesPlayed = Integer.parseInt(cleanInput(unparsedSite.get(i+10)));
					teams.add(new Team(teamTag, name, wins, losses, mp, plusMinus, winPercent, pointsFor, pointsAgainst, pointsDiff, gamesPlayed));
				}catch(NumberFormatException nfe){
					
				}
			}
		}
	}
	
	private String cleanInput(String input){
        return input.replaceAll("\\<[^>]*>","").replaceAll("\t", "");
	}
	
}

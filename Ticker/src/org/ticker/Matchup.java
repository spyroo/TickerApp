package org.ticker;

import java.util.HashMap;
import java.util.Map;

public class Matchup {
	
	private Map<String, Integer> teamScores;
	private String mapName;
	
	public Matchup(String team1, String team2){
		teamScores = new HashMap<String, Integer>();
		teamScores.putIfAbsent(team1, 0);
		teamScores.putIfAbsent(team2, 0);
	}
	
	public void incScore(String team){
		if(teamScores.containsKey(team))
			teamScores.put(team, teamScores.get(team) + 1);
	}
	
	public String getFormattedScores(){
		String temp = "|";
		
		String team1 = (String) teamScores.keySet().toArray()[0];
		String team2 = (String) teamScores.keySet().toArray()[1];
		
		temp += " " + team1 + " - " + teamScores.get(team1) + " ";
		if(teamScores.get(team1) > teamScores.get(team2)){
			temp += ">";
		}else if(teamScores.get(team1) < teamScores.get(team2)){
			temp += "<";
		}else{
			temp += "=";
		}
		temp += " " + teamScores.get(team2)+ " - " + team2 + " ";
		
		return temp;
		
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	
	public String getTeamOne(){
		return (String) teamScores.keySet().toArray()[0];
	}
	
	public String getTeamTwo(){
		return (String) teamScores.keySet().toArray()[1];
	}
	
	
	
}

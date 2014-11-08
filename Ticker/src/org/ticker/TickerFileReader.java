package org.ticker;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TickerFileReader {
	
	private File matchupList;
	private File tickerText;
	private File scoreboardFile;
	
	public TickerFileReader(){
		matchupList = new File("matchuplist.txt");
		tickerText = new File("tickerText.txt");
		scoreboardFile = new File("scoreboardFile.txt");
		try {
			if(matchupList.createNewFile()){
				writeDefaultString();
			}
			tickerText.createNewFile();
			scoreboardFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MatchupList getMatchupList(){
		MatchupList ml = new MatchupList();
		try {
			FileReader fr = new FileReader(matchupList);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null){
				if(!line.substring(0, 2).equals("/*")){
					String[] info = line.split("__vs__");
					if(info.length == 2){
						ml.addMatchup(new Matchup(info[0], info[1]));
					}
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ml;
	}
	
	public void writeDefaultString(){
		try {
			FileWriter fw = new FileWriter(matchupList);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("/* This is the matchup file, to make a matchup to be read by the program, enter it in this format\n/* jk__vs__knd");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeToTicker(String stringToWrite){
		try {
			FileWriter fw = new FileWriter(tickerText);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(stringToWrite);
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeToScoreboard(String stringToWrite){
		try {
			FileWriter fw = new FileWriter(scoreboardFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(stringToWrite);
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

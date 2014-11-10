package org.ticker;

import java.util.ArrayList;

public class TickerMain implements Runnable{
	
	private TickerWindow tw;
	private boolean started;
	private int time;
	private int pos;
	private ArrayList<Team> teams;
	private ScoreboardCreator scores;
	private TickerFileReader tfr;
	private String currentlyDisplayed;
	
	public TickerMain(TickerWindow tw, boolean started){
		this.tw = tw;
		this.started = started;
		time= 0;
		pos = 1;
		scores = new ScoreboardCreator();
		teams = scores.getTeams();
		tfr = new TickerFileReader();
		currentlyDisplayed = "";
	}
	
	public void setStarted(boolean started){
		this.started = started;
	}
	
	public boolean getStarted(){
		return started;
	}
	
	public void setTime(int mills){
		this.time = mills;
	}
	
	public int getTime(){
		return time;
	}

	public void rewriteTicker(TickerFileReader tfr, MatchupList ml) {
		tfr.writeToTicker(ml.getTickerText());
		System.out.println(ml.getTickerText());
	}

	public void setCurrentlyDisplayed(String toDisplay){
		this.currentlyDisplayed = toDisplay;
		tfr.writeToScoreboard(currentlyDisplayed);
		tw.setTitle(currentlyDisplayed);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while(true){
			if(started){
				if(time < 0){
					if(!displayNext()){
						scores.rereadTeams();
						teams = scores.getTeams();
						time = getTimeBetweenRepeat();
						setCurrentlyDisplayed("");
					}else{
						time = getTimeBetweenSlides();
					}
				}
				
				time--;
			}
			System.out.println(currentlyDisplayed);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int getTimeBetweenSlides() {
		return tw.getTimeBetweenSlides();
	}

	private int getTimeBetweenRepeat() {
		return tw.getTimeBetweenRepeat();
	}

	private boolean displayNext() {
		if(pos-1 < teams.size()){
			Team s = teams.get(pos-1);
			setCurrentlyDisplayed("#" + pos + ": " + s.getName() + " W" + s.getWins() + " L" + s.getLosses());
			pos++;
			return true;
		}

		pos = 1;
		return false;
	}

}

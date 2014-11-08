package org.ticker;

public class Team {

	private String tag, name;
	private int wins, losses, plusMinus, pointsFor, pointsAgainst, pointsDiff, gamesPlayed;
	private double matchpoints, winPercent;
	
	public Team(String tag, String name, int wins, int losses, double matchpoints, int plusMinus, double winPercent, int pointsFor, int pointsAgainst, int pointsDiff, int gamesPlayed){
		this.tag = tag;
		this.wins = wins;
		this.losses = losses;
		this.matchpoints = matchpoints;
		this.plusMinus = plusMinus;
		this.winPercent = winPercent;
		this.pointsFor = pointsFor;
		this.pointsAgainst = pointsAgainst;
		this.pointsDiff = pointsDiff;
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * @return the plusMinus
	 */
	public int getPlusMinus() {
		return plusMinus;
	}

	/**
	 * @param plusMinus the plusMinus to set
	 */
	public void setPlusMinus(int plusMinus) {
		this.plusMinus = plusMinus;
	}

	/**
	 * @return the pointsFor
	 */
	public int getPointsFor() {
		return pointsFor;
	}

	/**
	 * @param pointsFor the pointsFor to set
	 */
	public void setPointsFor(int pointsFor) {
		this.pointsFor = pointsFor;
	}

	/**
	 * @return the pointsAgainst
	 */
	public int getPointsAgainst() {
		return pointsAgainst;
	}

	/**
	 * @param pointsAgainst the pointsAgainst to set
	 */
	public void setPointsAgainst(int pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}

	/**
	 * @return the pointsDiff
	 */
	public int getPointsDiff() {
		return pointsDiff;
	}

	/**
	 * @param pointsDiff the pointsDiff to set
	 */
	public void setPointsDiff(int pointsDiff) {
		this.pointsDiff = pointsDiff;
	}

	/**
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @param gamesPlayed the gamesPlayed to set
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * @return the winPercent
	 */
	public double getWinPercent() {
		return winPercent;
	}

	/**
	 * @param winPercent the winPercent to set
	 */
	public void setWinPercent(double winPercent) {
		this.winPercent = winPercent;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * @param losses the losses to set
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}

	/**
	 * @return the matchpoints
	 */
	public double getMatchpoints() {
		return matchpoints;
	}

	/**
	 * @param matchpoints the matchpoints to set
	 */
	public void setMatchpoints(double matchpoints) {
		this.matchpoints = matchpoints;
	}
	@Override
	public String toString(){
		return tag + "," + wins + "," + losses + "," + matchpoints + "," + plusMinus + "," + winPercent + "," + pointsFor + "," + pointsAgainst + "," + pointsDiff + "," + gamesPlayed;
	}
	
}

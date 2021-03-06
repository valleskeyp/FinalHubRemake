package com.valleskeyp.WebDefender;

public interface GoogleInterface {
	public void login();
	public void logout();
	
	//get if client is signed in to Google+
	public boolean getSignedIn();

	//submit a score to a leaderboard
	public void submitScore(int score);

	//gets the scores and displays them through googles default widget
	public void getScores();

	//gets the score and gives access to the raw score data
	public void getScoresData();

	//extra - loads offline scores
	//public void goOfflineBoard();

	//extra - popup for name entry
	//public void scorePopup(int score, int level);

	//load achievements
	public void getAchievementData();

	//unlock achievement
	public void unlockAchievement(String achievement_id);

	//increment achievement
	public void incrementAchievement(String achievement_id, int amount);
}
package com.valleskeyp.WebDefender;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;

public class MainActivity extends AndroidApplication implements GoogleInterface, GameHelperListener{
	private GameHelper aHelper;
	private OnLeaderboardScoresLoadedListener theLeaderboardListener;
	
	public MainActivity(){
		aHelper = new GameHelper(this);
        aHelper.enableDebugLog(true, "MYTAG");
        //create a listener for getting raw data back from leaderboard
        theLeaderboardListener = new OnLeaderboardScoresLoadedListener() {
			@Override
			public void onLeaderboardScoresLoaded(int arg0,
					LeaderboardBuffer arg1, LeaderboardScoreBuffer arg2) {
				for(int i = 0; i < arg2.getCount(); i++) {
					System.out.println(arg2.get(i).getScoreHolderDisplayName() + " : " + arg2.get(i).getDisplayScore());
				}		
			}
		};
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        aHelper.setup(this);
        initialize(new WebDefender(this), cfg);
    }

    @Override
    protected void onStart() {
    	super.onStart();
    	aHelper.onStart(this);
    }
    @Override
    protected void onStop() {
    	super.onStop();
    	aHelper.onStop();
    }
	
    @Override
	protected void onActivityResult(int request, int response, Intent data) {
		super.onActivityResult(request, response, data);
		aHelper.onActivityResult(request, response, data);
	}
	//
	public void onSignInFailed() {
		
	}

	public void onSignInSucceeded() {
		
	}

	public void login() {
		try {
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					aHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (final Exception ex){

		}
	}

	public void logout() {
		try {
			runOnUiThread(new Runnable(){

				//@Override
				public void run(){
					aHelper.signOut();
				}
			});
		} catch (final Exception ex){

		}

	}

	public boolean getSignedIn() {
		return aHelper.isSignedIn();
	}

	public void submitScore(int _score) {
		aHelper.getGamesClient().submitScore(getString(R.string.leaderBoardID), _score);	
	}

	public void getScores() {
		startActivityForResult(aHelper.getGamesClient().getLeaderboardIntent(getString(R.string.leaderBoardID)), 105);	
	}

	public void getScoresData() {
		aHelper.getGamesClient().loadPlayerCenteredScores(theLeaderboardListener,
				getString(R.string.leaderBoardID), 
				1, 
				1, 
				25)	;
	}
	
	public void getAchievementData() {
		startActivityForResult(aHelper.getGamesClient().getAchievementsIntent(), 205);
	}
	
	public void unlockAchievement(String achievement_id) {
		if (achievement_id.equals("ach_survive")) {
			aHelper.getGamesClient().unlockAchievement(this.getString(R.string.ach_survive));
		} else if (achievement_id.equals("ach_surviveMedium")) {
			aHelper.getGamesClient().unlockAchievement(this.getString(R.string.ach_surviveMedium));
		}else if (achievement_id.equals("ach_surviveHard")) {
			aHelper.getGamesClient().unlockAchievement(this.getString(R.string.ach_surviveHard));
		}
	}
	
	public void incrementAchievement(String achievement_id, int amount) {
		if (achievement_id.equals("ach_smallFry")) {
			aHelper.getGamesClient().incrementAchievement(this.getString(R.string.ach_smallFry), amount);
		} else if (achievement_id.equals("ach_middleMan")) {
			aHelper.getGamesClient().incrementAchievement(this.getString(R.string.ach_middleMan), amount);
		} else if (achievement_id.equals("ach_heavyLift")) {
			aHelper.getGamesClient().incrementAchievement(this.getString(R.string.ach_heavyLift), amount);
		} else if (achievement_id.equals("ach_brawlin")) {
			aHelper.getGamesClient().incrementAchievement(this.getString(R.string.ach_brawlin), amount);
		}
	}
	
}
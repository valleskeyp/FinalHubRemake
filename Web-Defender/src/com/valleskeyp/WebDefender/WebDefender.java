package com.valleskeyp.WebDefender;

import com.badlogic.gdx.Game;
import com.valleskeyp.WebDefender.screens.SplashScreen;

public class WebDefender extends Game {
	private GoogleInterface platformInterface;
	
	public WebDefender(GoogleInterface aInterface) {
		platformInterface = aInterface;
	}

	@Override
	public void create() {		
		setScreen(new SplashScreen(platformInterface));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}

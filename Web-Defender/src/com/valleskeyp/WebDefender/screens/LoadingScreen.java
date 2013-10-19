package com.valleskeyp.WebDefender.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.valleskeyp.WebDefender.GoogleInterface;

public class LoadingScreen implements Screen, InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite loadingScreen;
	GoogleInterface platformInterface;
	
	private float loaded = 0;
	private boolean appeared = true;
	
	public LoadingScreen(GoogleInterface aInterface) {
		platformInterface = aInterface;
	}

	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
				
		texture = new Texture(Gdx.files.internal("data/loadingScreen.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 800, 480);
		
		loadingScreen = new Sprite(region);
		loadingScreen.setSize(1.05f, 1.05f * loadingScreen.getHeight() / loadingScreen.getWidth());
		loadingScreen.setOrigin(loadingScreen.getWidth()/2, loadingScreen.getHeight()/2);
		loadingScreen.setPosition(-loadingScreen.getWidth()/2, -loadingScreen.getHeight()/2);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		loadingScreen.draw(batch);
		loaded += dt;
		if (loaded > 2 && appeared == true) {
			appeared = false;
			((Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen(platformInterface));
		}
		batch.end();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK) {
			
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}
}

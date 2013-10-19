package com.valleskeyp.WebDefender;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Web {
	
	private Sprite web;
	
	public Texture texture, texture2, texture3, texture4, texture5, texture6;
	public float xCoord, yCoord;
	public String web_type;
	public boolean isBroken = false;
	public int slotNumber;
	public boolean hasFly = false;
	private Animation animation;
	private float time = 999;
	
	public Web(float x, float y, String web_area, int slot_number) {
		xCoord = x;
		yCoord = y;
		web_type = web_area;
		slotNumber = slot_number;
		
		if (web_area.equals("top")) {
			texture = new Texture(Gdx.files.internal("data/top_web.png"));
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			texture2 = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation0.png"));
			texture3 = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation1.png"));
			texture4 = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation2.png"));
			texture5 = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation3.png"));
			texture6 = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation4.png"));


			TextureRegion region = new TextureRegion(texture, 0, 0, 160, 160);

			web = new Sprite(region);
			web.setSize(1000*.2f, 1000*.2f);
			web.setOrigin(web.getWidth()/2, web.getHeight()/2);
			web.setPosition(x, y);
			
			animation = new Animation(1/5f,
					new TextureRegion(texture2, 0, 0, 160, 160),
					new TextureRegion(texture3, 0, 0, 160, 160),
					new TextureRegion(texture4, 0, 0, 160, 160),
					new TextureRegion(texture5, 0, 0, 160, 160),
					new TextureRegion(texture6, 0, 0, 160, 160)
			);
		} else if (web_area.equals("bottom")) {
			texture = new Texture(Gdx.files.internal("data/bottom_web.png"));
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			texture2 = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation0.png"));
			texture3 = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation1.png"));
			texture4 = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation2.png"));
			texture5 = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation3.png"));
			texture6 = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation4.png"));
			
			TextureRegion region = new TextureRegion(texture, 0, 0, 160, 160);

			web = new Sprite(region);
			web.setSize(1000*.2f, 1000*.2f);
			web.setOrigin(web.getWidth()/2, web.getHeight()/2);
			web.setPosition(x, y);
			
			animation = new Animation(1/5f,
					new TextureRegion(texture2, 0, 0, 160, 160),
					new TextureRegion(texture3, 0, 0, 160, 160),
					new TextureRegion(texture4, 0, 0, 160, 160),
					new TextureRegion(texture5, 0, 0, 160, 160),
					new TextureRegion(texture6, 0, 0, 160, 160)
			);
		}
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch batch, float dt) {
		if (animation.isAnimationFinished(time)) {
			web.draw(batch);
		} else {
			batch.draw(animation.getKeyFrame(time += dt*3), xCoord, yCoord, 1000*.2f, 1000*.2f);
		}
	}
	
	// follow with actions or things affecting the fly
	// ex. return the Fly for checks, animate actions
	
	public void breakWeb() {
		isBroken = true;
		time = 0;
		if (web_type.equals("top")) {
			texture = new Texture(Gdx.files.internal("data/webAnimation/topWebAnimation4.png"));
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			TextureRegion region = new TextureRegion(texture, 0, 0, 160, 160);

			web = new Sprite(region);
			web.setSize(1000*.2f, 1000*.2f);
			web.setOrigin(web.getWidth()/2, web.getHeight()/2);
			web.setPosition(xCoord, yCoord);
		} else {
			texture = new Texture(Gdx.files.internal("data/webAnimation/botWebAnimation4.png"));
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

			TextureRegion region = new TextureRegion(texture, 0, 0, 160, 160);

			web = new Sprite(region);
			web.setSize(1000*.2f, 1000*.2f);
			web.setOrigin(web.getWidth()/2, web.getHeight()/2);
			web.setPosition(xCoord, yCoord);
		}
	}
	
	public void dispose() {
		texture.dispose();
		texture2.dispose();
		texture3.dispose();
		texture4.dispose();
		texture5.dispose();
		texture6.dispose();
	}
}

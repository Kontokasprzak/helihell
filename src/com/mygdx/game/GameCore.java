package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.Start;

public class GameCore extends Game
{
	public SpriteBatch batch;
	public OrthographicCamera camera;

	public GameCore() {
		super();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(800,480);
        camera.position.set(400,240,0);


		this.setScreen(new Start(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
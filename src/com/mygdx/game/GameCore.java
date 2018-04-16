package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Meneger.GraphicMeneger;
import com.mygdx.game.Screens.MissionsScreen.Mission2;
import com.mygdx.game.Screens.Start;

public class GameCore extends Game
{
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public OrthographicCamera cameraUserLayer;
	public GraphicMeneger graphicMeneger;

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
		cameraUserLayer = new OrthographicCamera(800,480);
		graphicMeneger=new GraphicMeneger();
		this.setScreen(new Mission2(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
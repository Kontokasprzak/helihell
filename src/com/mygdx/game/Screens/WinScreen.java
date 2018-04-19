package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;
import com.mygdx.game.Screens.MissionsScreen.Mission1;
import com.mygdx.game.Screens.MissionsScreen.Mission2;
import com.mygdx.game.Screens.MissionsScreen.Mission3;
import com.mygdx.game.Screens.MissionsScreen.Mission4;
import com.mygdx.game.Screens.MissionsScreen.Mission5;
import com.mygdx.game.Singleton;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class WinScreen implements Screen {
    BitmapFont congratulations;
    GameCore game;
    Texture texture;
    public WinScreen(GameCore game){
        congratulations= new BitmapFont();
        this.game=game;
        game.camera.position.set(0,0,0);
        int i=Singleton.getInstance().getLevel();
        i+=1;
        Gdx.app.log("Singleton",""+i);
        Singleton.getInstance().putLevel(i);
        game.shootMeneger.reset();
        texture=new Texture("winScreen.png");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.camera.position.set(0,0,0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(texture,-400,-240);
        congratulations.draw(game.batch,"Congratulations",0,0);
        game.batch.end();
        if(Gdx.input.isTouched()){game.setScreen(new Start(game));}
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.GameCore;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class GameOver implements Screen{
    BitmapFont gameOver;
    GameCore game;
    public GameOver(GameCore game){
        gameOver= new BitmapFont();
        this.game=game;
        game.camera.position.set(0,0,0);
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
        gameOver.draw(game.batch,"GAME OVER",0,0);
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



package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.GameCore;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by Wqawer on 2018-04-18.
 */

public class Options implements Screen{

        BitmapFont author;
        GameCore game;
    public Options(GameCore game){
        author= new BitmapFont();
        this.game=game;
        game.camera.position.set(0,0,0);
    }
        @Override
        public void show() {

    }

        @Override
        public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.camera.position.set(0,0,0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        author.draw(game.batch,"SOUND:",0,0);


        game.batch.end();
        if (input.isKeyPressed(Input.Keys.BACK)){
            game.setScreen(new Start(game));
        }
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

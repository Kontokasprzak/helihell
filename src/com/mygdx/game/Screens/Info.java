package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.GameCore;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class Info implements Screen {
    BitmapFont author;
    GameCore game;
    Button back;
    public Info(GameCore game){
        author= new BitmapFont();
        this.game=game;
        game.camera.position.set(0,0,0);
        back=new Button(-400,180,game.graphicMeneger.no);
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
        author.draw(game.batch,"Made by: Michal Wqawer Wawer",0,0);
        author.draw(game.batch,"Graphic: Sebastian Nescio Urbanski",0,-30);
        author.draw(game.batch,"Concept Artist: Antonina Tola Kilian",0,-60);
        author.draw(game.batch,"Music: www.bensound.com",0,-90);
        back.sprite.draw(game.batch);
        game.batch.end();
       // if (input.isKeyPressed(Input.Keys.BACK)){
      //      game.setScreen(new Start(game));
      //  }
        if(back.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){game.setScreen(new Start(game));}
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

package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

public class Start implements Screen {
    GameCore game;
    BitmapFont logo;
    Button start, newGame, options, info;
    Music music;
    float logoX=0;
    float logoY=150;

    float helipo=-400;
    Sprite heli;


    public Start(GameCore game){

        this.game=game;
        start= new Button(0,0, game.graphicMeneger.startButton);
        newGame= new Button(0,-50, game.graphicMeneger.newGameButton);
        options= new Button(0,-100,game.graphicMeneger.optionsButton);
        info= new Button(300,200,game.graphicMeneger.infoButton);
        music= Gdx.audio.newMusic(Gdx.files.internal("Start.mp3"));
        if(Singleton.getInstance().getmusic()){music.play();}
        music.setLooping(true);
        logo=new BitmapFont();
        heli=new Sprite(game.graphicMeneger.player);
        heli.setPosition(-400,50);
        heli.flip(true,false);
        heli.setRotation(-30);


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        animation();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.camera.position.set(0,0,0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        heli.draw(game.batch);
        logo.draw(game.batch,"HELI HELL",logoX,logoY);
        start.sprite.draw(game.batch);
        newGame.sprite.draw(game.batch);
        options.sprite.draw(game.batch);
        info.sprite.draw(game.batch);
        game.batch.end();
        if(start.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){music.dispose();

            switch (Singleton.getInstance().getLevel()){
                case 0:
                    game.setScreen(new Mission1(game));
                    break;
                case 1:
                    game.setScreen(new Mission2(game));
                    break;
                case 2:
                    game.setScreen(new Mission3(game));
                    break;
                case 3:
                    game.setScreen(new Mission4(game));
                    break;
                case 4:
                    game.setScreen(new Mission5(game));
                    break;
            }}
        if(newGame.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){music.dispose();game.setScreen(new Mission1(game));}
        if (options.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){music.dispose();game.setScreen(new Options(game));}
        if(info.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){music.dispose();game.setScreen(new Info(game));}
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
    public void animation(){
       helipo+=50*Gdx.graphics.getDeltaTime();
       heli.setPosition(helipo,50);
        if(helipo>600){helipo=-600;}
    }
}

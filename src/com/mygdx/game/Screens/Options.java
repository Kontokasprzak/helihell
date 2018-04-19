package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.GameCore;
import com.mygdx.game.Singleton;

import static com.badlogic.gdx.Gdx.input;

/**
 * Created by Wqawer on 2018-04-18.
 */

public class Options implements Screen{

        BitmapFont author;
        GameCore game;
    Music music;
        Button no,yes;
        //accelerometr
    Button ano,ayes;
    Button back;
    public Options(GameCore game){
        author= new BitmapFont();
        this.game=game;
        game.camera.position.set(0,0,0);
        no=new Button(0,0,game.graphicMeneger.no);
        yes=new Button(120,0,game.graphicMeneger.yes);
        ano=new Button(0,-130,game.graphicMeneger.no);
        ayes=new Button(120,-130,game.graphicMeneger.yes);
        music= Gdx.audio.newMusic(Gdx.files.internal("Start.mp3"));
        back=new Button(-400,180,game.graphicMeneger.no);
        if(Singleton.getInstance().getmusic()){music.play();}
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
        author.draw(game.batch,"SOUND:",-200,0);
         author.draw(game.batch,"USE ACCELEROMETR:",-200,-90);
        yes.sprite.draw(game.batch);
        no.sprite.draw(game.batch);
            ayes.sprite.draw(game.batch);
            ano.sprite.draw(game.batch);
            back.sprite.draw(game.batch);
        if(yes.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){
                Singleton.getInstance().putmusic(true);}
            if(no.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){
                Singleton.getInstance().putmusic(false);}
            if(ayes.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){
                Singleton.getInstance().putAccelerometr(true);}
            if(ano.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){
                Singleton.getInstance().putAccelerometr(false);}
            if(back.isClicked(game.inputTranslator.translateX(Gdx.input.getX()),game.inputTranslator.translateY(Gdx.input.getY()))){game.setScreen(new Start(game));}

        game.batch.end();
            if(!Singleton.getInstance().getmusic()){music.dispose();}
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


/*package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Player.Bullet;
import com.mygdx.game.Player.Player;

/**
 * Created by Wqawer on 2018-04-01.


public class MainScreen implements Screen {
    GameCore game;
    Camera camera;
    Player heli;
    Texture mapa;
    Phisic phisic;
    Pixmap pixmap;
    Bullet bullet;
    float acc;


    public MainScreen(GameCore game){
        bullet= new Bullet(0,0);
        this.game=game;
        camera= new OrthographicCamera(800,480);
        heli = new Player(20,20);
        mapa = new Texture("mapa.png");
        camera.translate(400,240,0);
        phisic=new Phisic(heli);
        pixmap=new Pixmap(Gdx.files.internal("map.png"));
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();


        int kodKoloru=pixmap.getPixel((int)heli.positionX,(int)heli.positionY);
        Color color = new Color(kodKoloru);
        int blue=(int)(color.b*255);
        int green=(int)(color.g*255);
        int red=(int)(color.r*255);

        if(red==255&&blue<30) {
            Gdx.app.log("KOLOR","WIN");
        }
       // else{
         //   Gdx.app.log("KOLOR","NIEDZIALAM"+ blue);
        //}
        pixmap.drawPixmap(pixmap,0,0);

        camera.translate(phisic.horizontalForce,0,0);

        phisic.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(mapa,0,0);
        heli.render(game);
        if(Gdx.input.isTouched()){
            phisic.rotorDrag+=phisic.rotorPower*Gdx.graphics.getDeltaTime();
            bullet.render(this.game);
        }
        else{
            phisic.rotorDrag-=4*Gdx.graphics.getDeltaTime();
            if(phisic.rotorDrag<0){phisic.rotorDrag=0;}
        }
        game.batch.end();
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
*/

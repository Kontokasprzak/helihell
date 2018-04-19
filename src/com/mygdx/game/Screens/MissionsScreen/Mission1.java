package com.mygdx.game.Screens.MissionsScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.DialogWindow;
import com.mygdx.game.GameCore;
import com.mygdx.game.Phisic;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Player.PlayerRocket;
import com.mygdx.game.Screens.GameOver;
import com.mygdx.game.Screens.UserInterface;
import com.mygdx.game.Screens.Win;
import com.mygdx.game.Singleton;

import java.util.ArrayList;

import sun.management.jmxremote.SingleEntryRegistry;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class Mission1 implements Screen {
    int kodKoloru;
    Color color;
    Texture mapa;
    GameCore game;
    Player player;
    Phisic phisic;
    Pixmap pixmap;
    UserInterface userInterface;

    public Mission1(GameCore game){

        this.game=game;
        player=new Player(50,50, game);
        pixmap=new Pixmap(Gdx.files.internal("pixmap1.png"));
        mapa=new Texture("map1.png");
        phisic=new Phisic(player);
        Singleton.getInstance().putLevel(0);
        userInterface= new UserInterface(game,player,phisic);




    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        pixmanager();
        phisic.update();





        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       game.camera.position.set(player.positionX,player.positionY,0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();

        game.batch.draw(mapa,-500,0);
        player.render(game);
        scen();
        game.shootMeneger.shootUpdate(new ArrayList<EnemyUnit>(),player);
        game.batch.end();
        game.batch.setProjectionMatrix(game.cameraUserLayer.combined);
        game.batch.begin();
   //     flipButton.render(game.batch);
        game.batch.end();
        userInterface.render();
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
    public void pixmanager(){
        kodKoloru=pixmap.getPixel((int)player.positionX+500,(int)player.positionY);
        color = new Color(kodKoloru);
        int blue=(int)(color.b*255);
        int green=(int)(color.g*255);
        int red=(int)(color.r*255);
        if(blue==255){
            phisic.onGround=true;
            if(crash()){
                game.setScreen(new GameOver(game));
                return;
            }
        }
        else{phisic.onGround=false;}
        if(winManager(red)){game.setScreen(new Win(game));}


    }
    public boolean winManager(int red){


        if(red==255){
            return true;}
        return false;
    }
    public boolean crash(){

            return phisic.crash();


    }
    public void scen(){

            DialogWindow window=new DialogWindow("Jestes naszym najlepszym pilotem, musisz nam pomoc","Polec na zachod z zaopatrzeniem",game.graphicMeneger.general);
            window.render(game.batch);



    }

}

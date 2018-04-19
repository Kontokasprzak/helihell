package com.mygdx.game.Screens.MissionsScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.DialogWindow;
import com.mygdx.game.Enemy.Humve;
import com.mygdx.game.Enemy.Truck;
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

public class Mission4 implements Screen {
    int kodKoloru;
    Color color;
    Texture mapa;
    GameCore game;
    Player player;
    Phisic phisic;
    Pixmap pixmap;
    UserInterface userInterface;
    Humve humveBack;
    Humve humveFront;
    ArrayList<EnemyUnit> listOfEnemy;

    boolean picked=false;
    public Mission4(GameCore game){

        this.game=game;
        player=new Player(50,50, game);
        pixmap=new Pixmap(Gdx.files.internal("pixmap4.png"));
        mapa=new Texture("map4.png");
        phisic=new Phisic(player);
        userInterface= new UserInterface(game,player,phisic);
        humveBack=new Humve(game.graphicMeneger.hummer,2500,50);
        humveFront=new Humve(game.graphicMeneger.hummer,2700,50);
        listOfEnemy=new ArrayList<EnemyUnit>();
        setEnemy();


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
        for(EnemyUnit x:listOfEnemy)
        {
            x.render(game.batch);
            if(x instanceof Humve){((Humve) x).shoot(player.positionX,player.positionY,game);}
        }
        player.render(game);
        game.shootMeneger.shootUpdate(listOfEnemy,player);
        sceen();
        game.batch.end();
        player.shootDeleay-=1*Gdx.graphics.getDeltaTime();
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
        if(red==255){picked=true;}
        if(blue==255){
            phisic.onGround=true;
            if(crash()){
                game.setScreen(new GameOver(game));
                return;
            }
        }
        else{phisic.onGround=false;}
        if(winManager(green)){game.setScreen(new Win(game));}


    }
    public void setEnemy(){
        listOfEnemy.add(humveBack);
        listOfEnemy.add(humveFront);
    }
    public boolean winManager(int green){


        if(green==255&&picked==true){

            return true;}
        return false;
    }
    public boolean crash(){

        return phisic.crash();


    }
    public void sceen() {
        if(!picked){DialogWindow window = new DialogWindow("Nasi zostali ostrzelani przez wrogie jednostki", "zabierz rannych i wracaj do bazy", game.graphicMeneger.general);
        window.render(game.batch);}
        if(picked){DialogWindow window2 = new DialogWindow("Ludzie uratowania", "wracam do bazy", game.graphicMeneger.pilot);
            window2.renderat(game.batch,2500);
            DialogWindow window = new DialogWindow("Gratulacje", "Swietna robota", game.graphicMeneger.general);
            window.render(game.batch);}
}
    }

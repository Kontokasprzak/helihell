package com.mygdx.game.Screens.MissionsScreen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.Enemy.Bunker;
import com.mygdx.game.Enemy.Humve;
import com.mygdx.game.Enemy.Truck;
import com.mygdx.game.GameCore;
import com.mygdx.game.Phisic;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screens.Button;
import com.mygdx.game.Screens.GameOver;
import com.mygdx.game.Screens.UserInterface;
import com.mygdx.game.Screens.Win;
import com.mygdx.game.Singleton;

import java.util.ArrayList;

public class Mission3 implements Screen {
    int kodKoloru;
    Color color;
    Texture mapa;
    GameCore game;
    Player player;
    Phisic phisic;
    Pixmap pixmap;

    ArrayList<EnemyUnit> listOfEnemy;
    Truck truck;
    UserInterface userInterface;
    Humve humveBack,humveFront;


    public Mission3 (GameCore game){

        this.game=game;
        player=new Player(50,50, game);
        pixmap=new Pixmap(Gdx.files.internal("pixmap1.png"));
        mapa=new Texture("map1.png");
        phisic=new Phisic(player);
        listOfEnemy= new ArrayList<EnemyUnit>();
     userInterface= new UserInterface(game,player,phisic);
        truck=new Truck(game.graphicMeneger.truck,700,50);
        humveBack=new Humve(game.graphicMeneger.hummer,600,50);
        humveFront=new Humve(game.graphicMeneger.hummer,800,50);

        setEnemy();

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        pixmanager();
        phisic.update();




        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.camera.position.set(player.positionX,player.positionY,0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(mapa,0,0);
        player.render(game);
        game.shootMeneger.shootUpdate(listOfEnemy,player);
        for(EnemyUnit x:listOfEnemy)
        {
            x.render(game.batch);
        }
        truck.gotoTarget();
        humveFront.gotoTarget();
        humveBack.gotoTarget();
        humveFront.shoot(player.positionX,player.positionY,game);
        humveBack.shoot(player.positionX,player.positionY,game);
        if(truck.hitbox.getX()>3000){game.setScreen(new GameOver(game));}
        player.shootDeleay-=1*Gdx.graphics.getDeltaTime();
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
        kodKoloru=pixmap.getPixel((int)player.positionX,(int)player.positionY);
        color = new Color(kodKoloru);
        int blue=(int)(color.b*255);
        int green=(int)(color.g*255);
        int red=(int)(color.r*255);
        if(winManager()){game.setScreen(new Win(game));}
        if(blue==255){
            phisic.onGround=true;
            if(crash()){
                game.setScreen(new GameOver(game));
            }
        }
        else{phisic.onGround=false;}
    }


    //transport medyczny
    public boolean winManager(){


        if(listOfEnemy.size()==0){return true;}
        return false;
    }
    public boolean crash(){

        return phisic.crash();

    }
    public void setEnemy(){
        listOfEnemy.add(truck);
        listOfEnemy.add(humveBack);
        listOfEnemy.add(humveFront);
    }
}


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
import com.mygdx.game.Screens.GameOver;
import com.mygdx.game.Screens.UserInterface;
import com.mygdx.game.Screens.Win;

import java.util.ArrayList;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class Mission5 implements Screen {

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


        public Mission5 (GameCore game){

            this.game=game;
            player=new Player(50,50, game);
            pixmap=new Pixmap(Gdx.files.internal("pixmap2.png"));
            mapa=new Texture("map2.png");
            phisic=new Phisic(player);
            listOfEnemy= new ArrayList<EnemyUnit>();
            userInterface= new UserInterface(game,player,phisic);
            truck=new Truck(game.graphicMeneger.truck,700,50);
            humveBack=new Humve(game.graphicMeneger.hummer,2500,50);
            humveFront=new Humve(game.graphicMeneger.hummer,2500,50);
            humveBack.flip();
            humveFront.flip();
            humveFront.speed=-50;
            humveBack.speed=-50;
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
            player.render(game);
            game.shootMeneger.shootUpdate(listOfEnemy,player);
            if(game.shootMeneger.shootUpdateTruck(truck)){game.setScreen(new GameOver(game));}
            for(EnemyUnit x:listOfEnemy)
            {
                x.render(game.batch);

                if(x instanceof Humve){((Humve) x).gotoTarget();((Humve) x).shoot(player.positionX,player.positionY,game);((Humve) x).shoot(truck.sprite.getX(),truck.sprite.getY(),game);}
            }
            truck.render(game.batch);
            truck.gotoTarget();

            player.shootDeleay-=1*Gdx.graphics.getDeltaTime();
            sceen();
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
            if(winManager()){game.setScreen(new Win(game));}
            if(blue==255){
                phisic.onGround=true;
                if(crash()){
                    game.setScreen(new GameOver(game));
                }
            }
            else{phisic.onGround=false;}
        }



        public boolean winManager(){


            if(truck.sprite.getX()>2500){return true;}
        return false;}
        public boolean crash(){

            return phisic.crash();

        }
        public void setEnemy(){

            listOfEnemy.add(humveBack);
            listOfEnemy.add(humveFront);
        }
        public void sceen() {{DialogWindow window = new DialogWindow("Napewno czeka cie awans, Niedaleko ciebie znajduje sie konwoj", "polec na zachod i zatrzymaj transport zanim nam ucieknie", game.graphicMeneger.general);
                window.render(game.batch);}

        }
    }

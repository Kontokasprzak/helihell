package com.mygdx.game.Screens.MissionsScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.DialogWindow;
import com.mygdx.game.Enemy.Bunker;
import com.mygdx.game.Enemy.Tower;
import com.mygdx.game.GameCore;
import com.mygdx.game.Phisic;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screens.Button;
import com.mygdx.game.Screens.GameOver;
import com.mygdx.game.Screens.UserInterface;
import com.mygdx.game.Screens.Win;

import java.util.ArrayList;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class Mission2 implements Screen {
    int kodKoloru;
    Color color;
    Texture mapa;
    GameCore game;
    Player player;
    Phisic phisic;
    Pixmap pixmap;
    Button fire, flip;
    ArrayList<EnemyUnit> listOfEnemy;
    UserInterface userInterface;
    Tower tower,tower2;
    Bunker bunker;


    public Mission2(GameCore game) {

        this.game = game;
        player = new Player(50, 50, game);
        pixmap = new Pixmap(Gdx.files.internal("pixmap2.png"));
        mapa = new Texture("map2.png");
        phisic = new Phisic(player);
        listOfEnemy = new ArrayList<EnemyUnit>();
        fire = new Button(200, -200, game.graphicMeneger.shootButton);
        flip = new Button(250, -150, game.graphicMeneger.flipButton);

        userInterface = new UserInterface(game, player, phisic);
        tower = new Tower(game.graphicMeneger.tower, 1500, 50);
        bunker = new Bunker(game.graphicMeneger.bunker, 1600, 50);
        tower2 = new Tower(game.graphicMeneger.tower, 1700, 50);
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

        game.camera.position.set(player.positionX, player.positionY, 0);
        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        sceen();
        game.batch.draw(mapa, -500, 0);
        player.render(game);
        game.shootMeneger.shootUpdate(listOfEnemy, player);
        for (EnemyUnit x : listOfEnemy) {
            x.render(game.batch);
            if (x instanceof Tower) {
                ((Tower) x).shoot(player.positionX, player.positionY, game);
            }
        }

        player.shootDeleay -= 1 * Gdx.graphics.getDeltaTime();
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

    public void pixmanager() {
        kodKoloru = pixmap.getPixel((int) player.positionX+500, (int) player.positionY);
        color = new Color(kodKoloru);
        int blue = (int) (color.b * 255);
        int green = (int) (color.g * 255);
        int red = (int) (color.r * 255);
        if (winManager(green)) {
            game.setScreen(new Win(game));
        }
        if (blue == 255) {
            phisic.onGround = true;
            if (crash()) {
                game.setScreen(new GameOver(game));
            }
        } else {
            phisic.onGround = false;
        }
    }

    public boolean winManager(int green) {



        if (listOfEnemy.size() == 0&&green==255) {
            return true;
        }
        return false;
    }

    public boolean crash() {

        return phisic.crash();


    }

    public void setEnemy() {
        listOfEnemy.add(tower);
        listOfEnemy.add(bunker);
        listOfEnemy.add(tower2);
    }

    public void sceen() {
        if(listOfEnemy.size()>0){
        DialogWindow window = new DialogWindow("Idzie ci bardzo dobrze", "Polec na zachod zbombarduj baze wroga i wroc", game.graphicMeneger.general);
        window.render(game.batch);}
        else {
            DialogWindow window = new DialogWindow("Swietna robota", "Tak trzymaj", game.graphicMeneger.general);
            window.render(game.batch);}
    }
}
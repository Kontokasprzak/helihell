package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.GameCore;
import com.mygdx.game.Phisic;
import com.mygdx.game.Player.Player;

/**
 * Created by Wqawer on 2018-04-18.
 */

public class UserInterface {

    GameCore game;
    Button fire, flip,steringWheel;
    Player player;
    Phisic phisic;
    public UserInterface(GameCore game, Player player, Phisic phisic) {
        this.game=game;
        fire= new Button(200,-200,game.graphicMeneger.shootButton);
        flip= new Button(250,-150,game.graphicMeneger.flipButton);
        steringWheel=new Button(-250,-200,game.graphicMeneger.steringWheel);
        this.player=player;
        this.phisic=phisic;
    }
    public void render(){game.batch.setProjectionMatrix(game.cameraUserLayer.combined);
        game.batch.begin();
        fire.sprite.draw(game.batch);
        flip.sprite.draw(game.batch);
        steringWheel.sprite.draw(game.batch);
        if(Gdx.input.isTouched()) {
            if (fire.isClicked(game.inputTranslator.translateX(Gdx.input.getX()), game.inputTranslator.translateY(Gdx.input.getY()))) {
                player.shoot();
            }
            if (flip.isClicked(game.inputTranslator.translateX(Gdx.input.getX()), game.inputTranslator.translateY(Gdx.input.getY()))){
                player.flip();
            }

            if(steringWheel.isClicked(game.inputTranslator.translateX(Gdx.input.getX()), game.inputTranslator.translateY(Gdx.input.getY()))){
                phisic.steeringWheelInput(game.inputTranslator.translateX(Gdx.input.getX())-steringWheel.positionX,game.inputTranslator.translateY(Gdx.input.getY())-steringWheel.positionX,true);
            }

        }
        else {phisic.steeringWheelInput(64,0,false);}
        game.batch.end();}
}

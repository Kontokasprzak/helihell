package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;
import com.mygdx.game.Hitbox;
import com.mygdx.game.Screens.GameOver;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wqawer on 2018-04-01.
 */

public class Player {
    public Texture texture;
   public Sprite sprite;
    public int width;
    public int height;
    public Hitbox hitbox;
    public List<PlayerRocket> playerRocketList;
   public float positionX;
    public float positionY;
    public float shootDeleay;
    public boolean isFlip;
    public float delay;
    GameCore game;
    public Player(float positionX, float positionY, GameCore game){
        width=64;
        height=64;
        this.positionX=positionX;
        this.positionY=positionY;
        texture= new Texture("heli.png");
        sprite=new Sprite(texture);
        sprite.flip(true,false);
        hitbox= new Hitbox((int)positionX,(int)positionY,width,height);
        playerRocketList= new ArrayList<PlayerRocket>();
        this.game= game;
        isFlip=false;

    }
    public void render(GameCore game){
      sprite.setPosition(positionX,positionY);

        sprite.draw(game.batch);
        hitbox.setLocation((int)positionX,(int)positionY);
    }
    public void rotate(float stopnie){
        sprite.setRotation(stopnie);

    }
    public void shoot(){
        if(shootDeleay>0){return;}
        float rotation=sprite.getRotation();
        if (isFlip){rotation-=180;}
        game.shootMeneger.addProjectile(new PlayerRocket(positionX+64,positionY+15,rotation,250,0,game.graphicMeneger.rocket));
        shootDeleay=1;
    }


    public float getRotation(){
        return sprite.getRotation();
    }
    public void flip(){
        if(delay>0){return;}
        sprite.flip(true,false);
    delay=1;
    isFlip=!isFlip;}
    public void hit(){game.setScreen(new GameOver(game));
        }
}

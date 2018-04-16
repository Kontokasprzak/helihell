package com.mygdx.game.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;
import com.mygdx.game.Hitbox;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wqawer on 2018-04-01.
 */

public class Player {
    public Texture texture;
    Sprite sprite;
    public int width;
    public int height;
    public Hitbox hitbox;
    public List<PlayerRocket> playerRocketList;
   public float positionX;
    public float positionY;
    public Player(float positionX, float positionY){
        width=64;
        height=64;
        this.positionX=positionX;
        this.positionY=positionY;
        texture= new Texture("heli.png");
        sprite=new Sprite(texture);
        hitbox= new Hitbox((int)positionX,(int)positionY,width,height);
        playerRocketList= new ArrayList<PlayerRocket>();

    }
    public void render(GameCore game){
      sprite.setPosition(positionX,positionY);

        sprite.draw(game.batch);
        hitbox.setLocation((int)positionX,(int)positionY);
    }
    public void rotate(float stopnie){
        sprite.setRotation(stopnie);

    }


    public float getRotation(){
        return sprite.getRotation();
    }
    public void flip(){sprite.flip(true,false);}
}

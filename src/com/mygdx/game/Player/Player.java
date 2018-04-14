package com.mygdx.game.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;

import java.awt.Rectangle;

/**
 * Created by Wqawer on 2018-04-01.
 */

public class Player {
    Texture texture;
    Sprite sprite;
    Rectangle rectangle;
    public int width;
    public int height;
   public float positionX;
    public float positionY;
    public Player(float positionX, float positionY){
        width=64;
        height=64;
        this.positionX=positionX;
        this.positionY=positionY;
        /*rectangle=new Rectangle((int)positionX,(int)positionY,64,64);*/
        texture= new Texture("heli.png");
        sprite=new Sprite(texture);
    }
    public void render(GameCore game){
      sprite.setPosition(positionX,positionY);
    //  rectangle.setLocation((int)positionX,(int)positionY);
        sprite.draw(game.batch);
    }
    public void rotate(float stopnie){
        sprite.setRotation(stopnie);

    }
    boolean overlaps(float x,float y)
    {
    if(x>positionX&&x<positionX+width&&y>positionY&&y<positionY+height){return true;}
    return false;
    }
    public float getRotation(){
        return sprite.getRotation();
    }
}

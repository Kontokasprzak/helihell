package com.mygdx.game.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Wqawer on 2018-04-17.
 */

public class Button {
   public float positionX;
   public float positionY;
    public Sprite sprite;
    public Button(float positionX, float positionY, Texture texture){
        sprite= new Sprite(texture);
        sprite.setPosition(positionX,positionY);
        this.positionX=positionX+400;
        this.positionY=positionY+240;
    }
    public boolean isClicked(float x,float y){
        if(x>positionX&&x<positionX+sprite.getWidth()){
            if(y>positionY&&y<positionY+sprite.getHeight()){return true;}
        }
    return false;
    }

}

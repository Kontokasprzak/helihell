package com.mygdx.game;

/**
 * Created by Wqawer on 2018-04-16.
 */

public class Hitbox {
    float width;
    float height;
    float positionX;
    float positionY;
    public Hitbox(float positionX, float positionY, float width, float height){
        this.positionX=positionX;
        this.positionY=positionY;
        this.height=height;
        this.width=width;


    }
    public void setLocation(float positionX,float positionY){
        this.positionX=positionX;
        this.positionY=positionY;
    }
    public boolean overlaps(float positionX,float positionY){
        if(positionX>this.positionX&&positionX<this.positionX+width){
            if(positionY>this.positionY&&positionY<this.positionY+height){return true;}
        }
        return false;
    }
    public void transformPosition(float addX,float addY){
        positionX+=addX;
        positionY+=addY;
    }
    public float getX(){return positionX;}
    public float getY(){return positionY;}
}

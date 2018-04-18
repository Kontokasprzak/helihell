package com.mygdx.game.AbstractClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Wqawer on 2018-04-11.
 */

public abstract class Projectile {

    public  float radius;
    public float speed;
    public float rotation;
    public Texture texture;
    public Sprite sprite;
   public  float positionX;
    public float positionY;
    public Projectile(float positionX,float positionY,float rotation, float speed, float radius, Texture texture){
        this.texture= texture;
        this.radius=radius;
        this.rotation=rotation;
        this.speed=speed;
        this.positionX=positionX;
        this.positionY=positionY;
        sprite= new Sprite(texture);
        sprite.setPosition(positionX,positionY);


    }
    public void positionUpdate(){
        positionX+=speed* Gdx.graphics.getDeltaTime()* MathUtils.cos((float) ((Math.PI / 180)* (rotation)));
        positionY+=speed* Gdx.graphics.getDeltaTime() * MathUtils.sin((float) ((Math.PI / 180) * (rotation)));
        sprite.setPosition(positionX,positionY);
    }
    public void render(Batch batch){
        sprite.draw(batch);
    }
}

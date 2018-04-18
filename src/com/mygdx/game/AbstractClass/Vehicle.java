package com.mygdx.game.AbstractClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Wqawer on 2018-04-11.
 */

public abstract class Vehicle extends EnemyUnit{
    float speed=50;

    public Vehicle(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
    }
    public void gotoTarget(){
        sprite.translate(speed* Gdx.graphics.getDeltaTime(),0);
    }
    public void flip(){sprite.flip(true,false);}

}

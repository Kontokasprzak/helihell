package com.mygdx.game.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.Vehicle;

/**
 * Created by Wqawer on 2018-04-17.
 */

public class Truck extends Vehicle {
    float speed;
    public Truck(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
        speed=50;
        flip();
    }

}

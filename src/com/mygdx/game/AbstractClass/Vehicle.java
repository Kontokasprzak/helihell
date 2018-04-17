package com.mygdx.game.AbstractClass;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Wqawer on 2018-04-11.
 */

public abstract class Vehicle extends EnemyUnit{
    public Vehicle(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
    }

}

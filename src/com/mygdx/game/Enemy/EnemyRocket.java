package com.mygdx.game.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.Projectile;

/**
 * Created by Wqawer on 2018-04-18.
 */

public class EnemyRocket extends Projectile {
    public EnemyRocket(float positionX, float positionY, float rotation, float speed, float radius, Texture texture) {
        super(positionX, positionY, rotation, speed, radius, texture);
    }
}

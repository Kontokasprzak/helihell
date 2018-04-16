package com.mygdx.game.AbstractClass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Hitbox;

/**
 * Created by Wqawer on 2018-04-16.
 */
//Klas ma zawierać hp teksture i hitbox, wpinam to w jedną listę i mam jednego menegera
public abstract class EnemyUnit {
    Texture texture;
    int hp;
    Sprite sprite;
    Hitbox hitbox;

}

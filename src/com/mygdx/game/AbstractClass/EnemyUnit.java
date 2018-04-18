package com.mygdx.game.AbstractClass;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;
import com.mygdx.game.Hitbox;

/**
 * Created by Wqawer on 2018-04-16.
 */
//Klas ma zawierać hp teksture i hitbox, wpinam to w jedną listę i mam jednego menegera
public abstract class EnemyUnit {
    Texture texture;
    int hp;
    Sprite sprite;
    public Hitbox hitbox;
    public EnemyUnit(Texture texture, float positionX,float  positionY){
        this.texture=texture;
        sprite= new Sprite(texture);
        hitbox= new Hitbox(positionX,positionY,sprite.getWidth(),sprite.getHeight());
        hp=1;
        sprite.setPosition(positionX,positionY);
    }
    public void hitboxPositionUpdate(){hitbox.setLocation(sprite.getX(),sprite.getY());}
    public void render(Batch batch){
        sprite.draw(batch);
    }


}

package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.AbstractClass.Projectile;
import com.mygdx.game.GameCore;
import com.mygdx.game.Hitbox;

/**
 * Created by Wqawer on 2018-04-16.
 */

public class PlayerRocket extends Projectile{
    public PlayerRocket(float positionX, float positionY, float rotation, float speed, float radius, Texture texture) {
        super(positionX, positionY, rotation, speed, radius, texture);
    }
/*    float radius;
    float speed;
    public Hitbox hitbox;
    Texture texture;
    Sprite sprite;
    float speedHorizontal;
    float speedVertical;

    public PlayerRocket(float positionX, float positionY, float rotation) {
        hitbox = new Hitbox(positionX,positionY,5,5);
        speed=100;
        texture= new Texture("rocket.png");
        sprite=new Sprite(texture);
        sprite.setRotation(rotation);
        speedHorizontal=speed* Gdx.graphics.getDeltaTime()* MathUtils.cos((float) ((Math.PI / 180)* (rotation)));
        speedVertical=speed* Gdx.graphics.getDeltaTime() * MathUtils.sin((float) ((Math.PI / 180) * (rotation)));
    }

    public void render(GameCore game){
        hitbox.transformPosition(speedHorizontal,speedVertical);

        sprite.setPosition(hitbox.getX(),hitbox.getY());
        sprite.draw(game.batch);
    }

*/
}

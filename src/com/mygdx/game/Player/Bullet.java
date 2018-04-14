package com.mygdx.game.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameCore;

/**
 * Created by Wqawer on 2018-04-10.
 */

public class Bullet {
    Texture texture;
    Sprite sprite;
    public float positionX;
    public float positionY;
    public Bullet(float positionX, float positionY){
        this.positionX=positionX;
        this.positionY=positionY;
        texture= new Texture("bullet.png");
        sprite=new Sprite(texture);}
    public void render(GameCore game){
        sprite.setPosition(positionX,positionY);
        sprite.draw(game.batch);
    }
}

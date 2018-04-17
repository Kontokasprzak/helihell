package com.mygdx.game.Enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.GameCore;
import com.mygdx.game.Hitbox;

/**
 * Created by Wqawer on 2018-04-16.
 */

public class Bunker extends EnemyUnit {
    public Bunker(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
    }
  /*  public Texture texture;
    public Sprite sprite;
    public Hitbox hitbox;
    public short hp;
    GameCore game;
    public Bunker(GameCore game,float positionX, float positionY){
        texture= new Texture("bunker.png");
        sprite=new Sprite(texture);
        sprite.setPosition(positionX,positionY);
        hitbox=new Hitbox(positionX,positionY,64,64);
        hp=1;
        this.game=game;
    }
    public void render(){
        if(hp==0){return;}

    sprite.draw(game.batch);
    }*/
}

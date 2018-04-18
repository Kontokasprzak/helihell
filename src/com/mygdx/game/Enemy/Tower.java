package com.mygdx.game.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.GameCore;

/**
 * Created by Wqawer on 2018-04-18.
 */

public class Tower  extends EnemyUnit{
    double rotation;
    float shootDeleay=1;
    public Tower(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
    }
    public void shoot(float playerX, float playerY, GameCore game){
        if(Math.abs(hitbox.getX()-playerX)>200){return;}

            rotation =Math.tan( (playerY-hitbox.getY())/playerX-hitbox.getX())/(Math.PI / 180);
        if(shootDeleay>0){
           shootDeleay-=1* Gdx.graphics.getDeltaTime();
            return;}
        game.shootMeneger.addProjectile(new EnemyRocket(( hitbox.getX()+4),hitbox.getY()+80,(float) rotation,250,0,game.graphicMeneger.rocket));
        shootDeleay=1;

    }
}

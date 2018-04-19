package com.mygdx.game.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
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
        if(Math.abs(hitbox.getX()-playerX)>400){return;}


        if(shootDeleay>0){
           shootDeleay-=1* Gdx.graphics.getDeltaTime();
            return;}

        Vector2 vector2=new Vector2((playerX+50) -(hitbox.getX()+30),(playerY+50)-(hitbox.getY()+100));
        shootDeleay=1;
        game.shootMeneger.addProjectile(new EnemyRocket(hitbox.getX()+30,hitbox.getY()+100,vector2.angle(),200,0,game.graphicMeneger.rocket));


    }
}

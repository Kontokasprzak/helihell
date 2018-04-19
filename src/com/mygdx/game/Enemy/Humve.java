package com.mygdx.game.Enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.AbstractClass.Vehicle;
import com.mygdx.game.GameCore;

/**
 * Created by Wqawer on 2018-04-16.
 */

public class Humve extends Vehicle {
   public float speed;
    double rotation;
    float shootDeleay=1;
    public Humve(Texture texture, float positionX, float positionY) {
        super(texture, positionX, positionY);
        speed=50;
        flip();


    }
    public void shoot(float playerX, float playerY, GameCore game){
        if(Math.abs(hitbox.getX()-playerX)>400){return;}


        if(shootDeleay>0){
            shootDeleay-=1* Gdx.graphics.getDeltaTime();
            return;}

        Vector2 vector2=new Vector2((playerX+50) -(hitbox.getX()+30),(playerY+50)-(hitbox.getY()+20));
        shootDeleay=1;
        game.shootMeneger.addProjectile(new EnemyRocket(hitbox.getX()+30,hitbox.getY()+20,vector2.angle(),200,0,game.graphicMeneger.rocket));


    }
}

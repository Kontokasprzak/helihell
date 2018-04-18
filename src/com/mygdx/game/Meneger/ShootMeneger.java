package com.mygdx.game.Meneger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.AbstractClass.Projectile;
import com.mygdx.game.Enemy.EnemyRocket;
import com.mygdx.game.GameCore;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Player.PlayerRocket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wqawer on 2018-04-16.
 */

public class ShootMeneger {
   public List<Projectile> projectilesList;
   public Batch batch;

   public ShootMeneger(Batch batch){
      this.batch=batch;
      projectilesList= new ArrayList<Projectile>();
   }
   public void addProjectile(Projectile projectile){
   projectilesList.add(projectile);
   }
   public boolean isOut(Projectile projectail){if(projectail.positionX<0||projectail.positionX>3000||projectail.positionY>1000){return true;}
      return false;}
   public void  shootUpdate(ArrayList<EnemyUnit> listOfEnemy, Player player){
      for(int i=0;i<projectilesList.size();i++)
      {projectilesList.get(i).positionUpdate();
         projectilesList.get(i).render(batch);

       if (isOut(projectilesList.get(i))){projectilesList.remove(i);}
      else if(projectilesList.get(i) instanceof PlayerRocket){
         for(int j=0;j<listOfEnemy.size();j++)
         if(listOfEnemy.get(j).hitbox.overlaps(projectilesList.get(i).positionX,projectilesList.get(i).positionY)){listOfEnemy.remove(j);
         projectilesList.remove(i);}}
      else if(projectilesList.get(i) instanceof EnemyRocket){
            Gdx.app.log("HIT","Działam");
            if(player.hitbox.overlaps(projectilesList.get(i).positionX,projectilesList.get(i).positionY))
         player.hit();}

      }

      return;}
   public void reset(){
      projectilesList= new ArrayList<Projectile>();
   }
}

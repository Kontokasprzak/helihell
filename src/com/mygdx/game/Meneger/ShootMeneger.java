package com.mygdx.game.Meneger;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.AbstractClass.EnemyUnit;
import com.mygdx.game.AbstractClass.Projectile;
import com.mygdx.game.GameCore;
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
   public void removeProjectile(){return;}
   public void  shootUpdate(ArrayList<EnemyUnit> listOfEnemy){
      for(int i=0;i<projectilesList.size();i++)
      {projectilesList.get(i).positionUpdate();
         projectilesList.get(i).render(batch);
      if(projectilesList.get(i) instanceof PlayerRocket){
         for(int j=0;j<listOfEnemy.size();j++)
         if(listOfEnemy.get(j).hitbox.overlaps(projectilesList.get(i).positionX,projectilesList.get(i).positionY)){listOfEnemy.remove(j);
         projectilesList.remove(i);}
      }}

      return;}
}

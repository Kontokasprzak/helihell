package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screens.GameOver;

/**
 * Created by Wqawer on 2018-04-14.
 */

public class FlipButton {
    Player player;
    Texture texture;
    Sprite sprite;
    int delay;
    public FlipButton(Player player){
        texture=new Texture("flipButton.png");
        sprite= new Sprite(texture);
        this.player= player;
        delay=0;
    }
    public void render(Batch batch){
        sprite.setPosition(100,100);
        sprite.draw(batch);

    }
    public void onClick(){
    if(delay==0){
        player.flip();
        delay=10;
        return;
    }
    delay-=1* Gdx.graphics.getDeltaTime();
    }

}

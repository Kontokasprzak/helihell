package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Wqawer on 2018-04-11.
 */

public class DialogWindow {
    String text;
    String text2;
    Sprite sprite;
    BitmapFont bitmapFont;
    public DialogWindow(String text,String text2, Texture person)
    {
        this.text=text;
        this.text2=text2;
        sprite=new Sprite(person);
        sprite.setPosition(-350,-200);
        bitmapFont=new BitmapFont();

    }
    public void render(Batch batch){
        sprite.draw(batch);
        bitmapFont.draw(batch,""+text,-30,-50);
        bitmapFont.draw(batch,""+text2,-30,-70);

    }
    public void renderat(Batch batch,float x){
        sprite.setPosition(x-320,-200);
        bitmapFont.draw(batch,""+text,x,-50);
        bitmapFont.draw(batch,""+text2,x,-70);
    }

}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Wqawer on 2018-04-17.
 */

public class InputTranslator {
    float ratio;
    float width;
    float newX;
    float height;
    float newY;

    public InputTranslator() {

    }
    public float translateX(int x){
        width= Gdx.graphics.getWidth();

      ratio=x/width;
      newX=ratio*800;
      return newX;
    }
    public float translateY(int y){
        height= Gdx.graphics.getHeight();
        ratio=y/height;
        newY=480-(ratio*480);
        return newY;
    }
}

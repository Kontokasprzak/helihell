package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Wqawer on 2018-04-17.
 */

public class Singleton {
    private static Singleton instance = null;
    private Preferences prefs = null;
    protected Singleton() {
    prefs= Gdx.app.getPreferences("Prefernces");
    }
    public static Singleton getInstance(){
        if(instance== null){instance= new Singleton();}
        return instance;
        }
        public void putLevel(int result){
        prefs.putInteger("Level", result);
        prefs.flush();
        }
        public int getLevel(){
            return prefs.getInteger("Level");
        }
    public void putAccelerometr(boolean isActive){
        prefs.putBoolean("Accelerometr", isActive);
        prefs.flush();
    }
    public boolean putAccelerometr(){
        return prefs.getBoolean("Accelerometr");
    }

    }



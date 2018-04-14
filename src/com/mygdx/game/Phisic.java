package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Player.Player;

/**
 * Created by Wqawer on 2018-04-01.
 */

public class Phisic {
    public boolean onGround;
    public float gravityForce;
    public float rotorMaxSpeed;
    public float rotorSpeed;
    public float rotorAcceleration;
    public float verticalSpeed;
    public float horizontalSpeed;
    public float verticalAcceleration;
    public float horizontalAcceleration;
    public float windResistance;
    public float groundRriction;
    public float acc;
    public float maxVerticalSpeed;
    public float maxHorizontalSpeed;
    public Player player;


    public Phisic(Player player){
        this.player=player;
        horizontalAcceleration=0;
        verticalAcceleration=0;
        verticalSpeed=0;
        horizontalSpeed=0;
        gravityForce=3;
        rotorSpeed=0;
        rotorMaxSpeed=5;
        rotorAcceleration=0.5f;
        windResistance=0.01f;
        maxVerticalSpeed=5;
        maxHorizontalSpeed=5;
        groundRriction=1;
        onGround=true;



    }
    
    public void update() {
        this.setRotation();
        if (Gdx.input.isTouched()) {
            this.acceleration();
            Gdx.app.log("ACC","rotation="+player.getRotation());
        } else {
            rotorSpeed -= 1;
            if(rotorSpeed<0){rotorSpeed=0;}

        }
        verticalAcceleration = rotorSpeed * Gdx.graphics.getDeltaTime()* MathUtils.cos((float) ((Math.PI / 180)* (player.getRotation())));
        verticalSpeed += verticalAcceleration;
        if(!onGround){
        verticalSpeed -= gravityForce*Gdx.graphics.getDeltaTime();}
        if(verticalSpeed>maxVerticalSpeed){verticalSpeed=maxVerticalSpeed;}
        horizontalAcceleration = rotorSpeed * Gdx.graphics.getDeltaTime() * MathUtils.sin((float) ((Math.PI / 180) * (player.getRotation())));
        horizontalSpeed -= horizontalAcceleration;
        if(horizontalSpeed>maxHorizontalSpeed){horizontalSpeed=maxHorizontalSpeed;}
        if(horizontalSpeed<-maxHorizontalSpeed){horizontalSpeed=-maxHorizontalSpeed;}
        Gdx.app.log("SPEED",""+verticalSpeed);
        Gdx.app.log("ROTORSPEED",""+rotorSpeed);
        //air resistance simulation
        if (horizontalAcceleration == 0) {
            if (horizontalSpeed > 0) {
                if (horizontalSpeed < 0.02) {horizontalSpeed = 0;}
                else{horizontalSpeed-=windResistance;}
            }
            if(horizontalSpeed<0) {
                if (horizontalSpeed > -2) {horizontalSpeed = 0;}
                else {horizontalSpeed += windResistance;}
            }
        }
        player.positionX+=horizontalSpeed;
        player.positionY+=verticalSpeed;
    }
    public boolean crash(Color color){
        return false;
    }
    public void acceleration() {
        rotorSpeed += rotorAcceleration;
        if(rotorSpeed>rotorMaxSpeed){rotorSpeed=rotorMaxSpeed;}
    }

    public void setRotation(){
        acc=Gdx.input.getAccelerometerY();
        player.rotate(-acc*10);
    }
    public boolean crash(){
        if(Math.abs(verticalSpeed)+Math.abs(horizontalSpeed)>3){
            return true;
        }
        verticalSpeed=0;
        Gdx.app.log("Ground","SPEED: "+verticalSpeed );
        horizontalSpeed-=groundRriction*Gdx.graphics.getDeltaTime();
        return false;
    }
}


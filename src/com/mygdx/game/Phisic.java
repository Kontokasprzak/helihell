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
    public float[] accArray={0,0,0,0,0,0,0,0,0,0};
    public float wheelX,wheelY;
    float accAverage;
    public boolean isTouched;

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
        wheelX=0;
        wheelY=0;
        isTouched=false;





    }
    
    public void update() {
      //  if(acceleromet)
        //setRotationAccelerometr();
            //else

            acc=-((wheelX-64)/128)*90;

        if(player.positionY<60){acc=0;
            player.delay=1;
            player.shootDeleay=1;}
        for(int i=0;i<9;i++)
        {
            accArray[i]=accArray[i+1];
        }
        accArray[9]=acc;
        accAverage=(accArray[0]+accArray[1]+accArray[2]+accArray[3]+accArray[4]+accArray[5]+accArray[6]+accArray[7]+accArray[8]+accArray[9])/10;
        //if(acceleromet)player.rotate(-accAverage*10);
        // else
        player.sprite.setRotation(acc);
        if (Gdx.input.isTouched()&&isTouched) {
        //    this.acceleration();
            accelerationWheel();

        } else {
            rotorSpeed -= 1;

        }
        if(rotorSpeed<0){rotorSpeed=0;}
        verticalAcceleration = rotorSpeed * Gdx.graphics.getDeltaTime()* MathUtils.cos((float) ((Math.PI / 180)* (player.getRotation())));
        verticalSpeed += verticalAcceleration;
         if(!onGround){
        verticalSpeed -= gravityForce*Gdx.graphics.getDeltaTime();}
        if(verticalSpeed>maxVerticalSpeed){verticalSpeed=maxVerticalSpeed;}
        horizontalAcceleration = rotorSpeed * Gdx.graphics.getDeltaTime() * MathUtils.sin((float) ((Math.PI / 180) * (player.getRotation())));
        horizontalSpeed -= horizontalAcceleration;
        if(horizontalSpeed>maxHorizontalSpeed){horizontalSpeed=maxHorizontalSpeed;}
        if(horizontalSpeed<-maxHorizontalSpeed){horizontalSpeed=-maxHorizontalSpeed;}
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
        if(player.positionY>600){player.positionY=600;
        verticalSpeed=0;}
        if(player.positionY<40){player.positionY=40;
            verticalSpeed=0;}
        if(player.positionX<-50){player.positionX=-50;
        horizontalSpeed=0;}
        if(player.positionX>3000){player.positionX=3000;
            horizontalSpeed=0;}

            Gdx.app.log("Speed",""+verticalSpeed);

        player.positionX+=horizontalSpeed;
        player.positionY+=verticalSpeed;
        player.delay-=1*Gdx.graphics.getDeltaTime();
    }

    public void acceleration() {

        rotorSpeed += rotorAcceleration;
        if(rotorSpeed>rotorMaxSpeed){rotorSpeed=rotorMaxSpeed;}

    }





    public void setRotationAccelerometr(){
        acc=Gdx.input.getAccelerometerY();
    }


    public void accelerationWheel(){
        rotorSpeed += rotorAcceleration*(1+wheelY/128);
        if(rotorSpeed>rotorMaxSpeed*(1+wheelY/128)){rotorSpeed=rotorMaxSpeed*(1+wheelY/128);}
        Gdx.app.log("ACC","rotor="+rotorSpeed);
        }

    public boolean crash(){
        if(Math.abs(verticalSpeed)+Math.abs(horizontalSpeed)>3){
            return true;
        }
        verticalSpeed=0;
        Gdx.app.log("Ground","SPEED: "+verticalSpeed );
        if(Math.abs(horizontalSpeed)<groundRriction*Gdx.graphics.getDeltaTime()){horizontalSpeed=0;}
        else{ horizontalSpeed-=groundRriction*Gdx.graphics.getDeltaTime();}

        return false;
    }
    public void steeringWheelInput(float x,float y ,boolean isTouched){
    wheelX=x;
    wheelY=y;
    this.isTouched= isTouched;

    }

}


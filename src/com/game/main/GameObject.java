package com.game.main;

import java.awt.*;

public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY, velY2;
    protected float a = -0.03f;
    protected int time = 0;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getTopBounds();
    public abstract Rectangle getBottomBounds();
    public abstract Rectangle getInside();

    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return this.id;
    }
    public void setVelX(float velX){
        this.velX = velX;
    }
    public void setVelY(float velY){
        this.velY = velY;
    }
    public float getVelX(){
        return this.velX;
    }
    public float getVelY(){
        return this.velY;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}

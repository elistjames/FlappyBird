package com.game.main;

import java.awt.*;
import java.awt.geom.Path2D;

public class Floor extends GameObject{

    private Handler handler;
    private Path2D.Double parallelogram;
    private Color color;

    public Floor(int x, int y, ID id, Color color, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.color = color;

        velX = -5;
        velY = 0;
    }

    @Override
    public void tick() {
        x += velX;

        if(x <= -12){
            x = Game.WIDTH-2;
        }
    }


    public void render(Graphics g) {

        g.setColor(color);
        g.fillRect((int)x, (int)y, 15, 30);
    }

    public Rectangle getTopBounds() {
        return new Rectangle(0, (int)y, Game.WIDTH, 30);
    }

    public Rectangle getBottomBounds() {
        return null;
    }

    @Override
    public Rectangle getInside() {
        return null;
    }
}

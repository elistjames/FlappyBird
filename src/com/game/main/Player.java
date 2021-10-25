package com.game.main;

import java.awt.*;

public class Player extends GameObject{

    private Handler handler;
    private HUD hud;

    public Player(int x, int y, ID id, Handler handler, HUD hud){
        super(x, y, id);
        this.handler = handler;
        this.hud = hud;
        time = 0;
        velY = -8;
    }

    @Override
    public void tick() {
        time++;
        velY2 = velY - (a*(time));
        y += velY2;
        velY = velY2;
        y = Game.clamp((int)y, (int)0, (int)Game.HEIGHT-220);

        collision();
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.orange);
        g.fillRect((int)x, (int)y, 32, 25);
        g2d.setColor(Color.black);
        g2d.drawRect((int)x, (int)y, 32, 25);
        g.setColor(Color.orange.darker());
        g.fillRect((int)x+20, (int)y+10, 20, 10);
        g2d.setColor(Color.black);
        g2d.drawRect((int)x+20, (int)y+10, 20, 10);
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y+9, 10, 5);
        g2d.setColor(Color.black);
        g2d.drawRect((int)x, (int)y+9, 10, 5);
    }

    public void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Pipe){
                if(getTopBounds().intersects(tempObject.getTopBounds()) || getTopBounds().intersects(tempObject.getBottomBounds())){
                    //collision code
                    System.exit(1);
                }
                if(getTopBounds().intersects(tempObject.getInside())){
                    hud.setScoreTimer(hud.getScoreTimer()+1);
                }
            }
        }
    }

    public Rectangle getTopBounds() {
        return new Rectangle((int)x, (int)y, 32, 25);
    }

    public Rectangle getBottomBounds() {
        return null;
    }

    @Override
    public Rectangle getInside() {
        return null;
    }
}

package com.game.main;

import java.awt.*;

public class Pipe extends GameObject{
 
    private Handler handler;
    public Pipe(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX = -5;
        velY = 0;

    }

    @Override
    public void tick() {
        x += velX;

        if(x <= -100){
            handler.removeObject(this);
        }

    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //top pipefilling
        g.setColor(Color.green.darker());
        g.fillRect((int)x, (int)y-1000, (int)100, (int) 1000);

        //top pipe outline
        g2d.setColor(Color.black);
        g2d.drawRect((int)x, (int)y-1000, (int)100, (int)1000);

        //bottom pipe filling
        g.setColor(Color.green.darker());
        g.fillRect((int)x, (int)y+150, (int)100, (int)y+1000);

        //bottom pipe outline
        g2d.setColor(Color.black);
        g2d.drawRect((int)x, (int)y+150, (int)100, (int)y+1000);

        //top pipe cap filling
        g.setColor(Color.green.darker());
        g.fillRect((int)x-10, (int)y-50,(int)120, (int)50);

        //top pipe cap outline
        g2d.setColor(Color.black);
        g2d.drawRect((int)x-10, (int)y-50,(int)120, (int)50);

        //bottom pipe cap filling
        g.setColor(Color.green.darker());
        g.fillRect((int)x-10, (int)y+150,(int)120, (int)50);

        //bottom pipe cap outline
        g2d.setColor(Color.black);
        g2d.drawRect((int)x-10, (int)y+150,(int)120, (int)50);
    }

    public Rectangle getInside(){
        return new Rectangle((int)x+50,(int)y, 1, (int)150);
    }

    @Override
    public Rectangle getTopBounds() {
        return new Rectangle((int)x, (int)y-1000, (int)100, (int)1000);
    }

    public Rectangle getBottomBounds() {
        return new Rectangle((int)x, (int)y+155 , (int)100, (int)y+1000);
    }
}

package com.game.main;

import java.awt.*;

public class HUD {
    private int score = 0;
    private int scoreTimer = 0;

    public void tick(){
        if(scoreTimer >= 6) {
            score++;
            scoreTimer = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.getHSBColor(0, 75, 65));
        g.fillRect(0, 710, Game.WIDTH, 200);
        Font font = new Font("arial", 1, 30    );
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString(""+score, 345, 100);
    }

    public int getScoreTimer(){
        return this.scoreTimer;
    }

    public void setScoreTimer(int scoreTimer) {
        this.scoreTimer = scoreTimer;
    }
}

package com.game.main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private int pipeTimer;
    private Random r = new Random();

    public Spawn(Handler handler){
        this.handler = handler;
    }

    public void tick(){
        pipeTimer++;

        if(pipeTimer >= 75){
            pipeTimer = 0;
            handler.addObject(new Pipe(Game.WIDTH, r.nextInt(500), ID.Pipe, handler));

        }
    }


}

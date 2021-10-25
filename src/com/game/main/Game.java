package com.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = -473349850293143017L;
    public static final int WIDTH = 700, HEIGHT = 900;

    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE{
        Menu,
        End,
        Game
    };

    public static STATE gameState = STATE.Menu;

    public Game(){
        handler = new Handler();
        spawner = new Spawn(handler );
        hud = new HUD();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Flappy Bird", this);
        r = new Random();
        handler.addObject(new Player(250, 450, ID.Player, handler, hud));
        handler.addObject(new Pipe(WIDTH, r.nextInt(500), ID.Pipe, handler));
        for(int i = 0; i < 30; i++){
            handler.addObject(new Floor((i*24), 700, ID.Floor, Color.green, handler));
            handler.addObject(new Floor(12+(i*24), 700, ID.Floor, Color.green.darker(), handler));
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if(var <= min)
            return var = min;
        else if (var >= max)
            return var = max;
        else
            return var;
    }

    public static void main(String args[]){
        new Game();
    }


}

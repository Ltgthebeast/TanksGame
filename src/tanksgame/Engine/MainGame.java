/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Engine;

import tanksgame.Window.Frame;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import javafx.embed.swing.SwingFXUtils;
import javax.swing.SwingUtilities;
import tanksgame.Input.Mouse;
import tanksgame.Objects.Button;
import tanksgame.Objects.ID;

/**
 *
 * @author Luke T Garceau
 */
public class MainGame extends Canvas implements Runnable{
    
    // vairables
    public static final int WIDTH = 900, HEIGHT = 600;
    public static final String TITLE = "Tanks";
    private Thread thread;
    public boolean running = false,
            first = true;
    
    // Mouse Variables
    public static double mouseX = 0, mouseY = 0;
    public static boolean mouse1Down = false, mouse2Down = false;
    
    // classes
    public static Handler handler;
    public static Mouse mouse = new Mouse();
    public static UseFulFunctions funct = new UseFulFunctions();
    public Frame frame;
    
    public MainGame(){
        frame = new Frame(WIDTH, HEIGHT, TITLE, this);
        
        this.handler = new Handler();
        
        // add Start Button
        handler.add(new Button(0, 0, 50, 50, ID.Button, null, Color.blue));
    }
    
    
    
    // starting the game
    public synchronized void start(){
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }
    
    // stopping the game
    public synchronized void stop(){
        try{
            this.thread.join();
            this.running = false;
        } catch (InterruptedException e){
            // sad face
        }
    }
    
    // main game loop
   @Override
   public void run() {
        requestFocus();
	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0D;
	double ns = 1.0E9D / amountOfTicks;
	double delta = 0.0D;
	long timer = System.currentTimeMillis();
	int frames = 0;
	while (this.running) {
	    long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
	    while (delta >= 1.0D) {
		tick();
		delta -= 1.0D;
	    }
	    if (this.running)
		render();
	    frames++;
	    //System.out.println("Frames: "+frames);

	    if (System.currentTimeMillis() - timer > 1000L) {
		timer += 1000L;

		frames = 0;
	    }
	}
	stop();
    }
    
    private void tick(){
        // tick all of the game objects
        handler.tick();
        mouseX = MouseInfo.getPointerInfo().getLocation().x;
        mouseY = MouseInfo.getPointerInfo().getLocation().y;  
        Point point = new Point(mouseX, mouseY),
                newPoint;
        SwingUtilities.convertPoint(GraphicsConfiguration., point, newPoint)
         
        
//        System.out.println("Mouse x: "+mouseX+" Mouse y: "+mouseY);
               
    }
    
    private void render(){
        // render all of the game objects
        
        BufferStrategy bs =  getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        
        g.translate(WIDTH/2, HEIGHT/2);
        
        
        // draw background
        
        g.setColor(new Color(210,180,140)); // beige
        g.fillRect(-WIDTH/2, -HEIGHT/2, WIDTH, HEIGHT);
        
        // render all gameobjects
        handler.render(g);
        g.dispose();
        bs.show();
    }
    
    public static void main(String args[]){
        new MainGame();
    }

}

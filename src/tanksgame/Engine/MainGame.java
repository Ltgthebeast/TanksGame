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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import tanksgame.Input.Keyboard;
import tanksgame.Input.Mouse;
import tanksgame.Objects.Button;
import tanksgame.Objects.ID;
import tanksgame.Objects.GameImage;
import tanksgame.Objects.Player;
import tanksgame.Screens.ControlScreen;

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
    public static int mouseButton = 0;
    
    // classes
    public static Handler handler;
    public static UseFulFunctions funct = new UseFulFunctions();
    public Frame frame;
    public static ControlScreen controlScreen = null;
    
    // Buttons
    public static Button start = new Button(-360, -240, 300, 50, ID.Button, null, Color.blue, "Start"),
            exit = new Button(-360, -180, 300, 50, ID.Button, null, Color.green, "Exit"),
            play = new Button(-360, -180, 250, 50, ID.Bullet, null, Color.red, "Play!");
    
    // GameObjects
    public static Player player = new Player(0, 0, 0, 0, ID.Tank, "");
    
    // Images
    public static GameImage tankOnStart = new GameImage(0, 0, 100, 100, ID.Image, "Images/tanque-comic.png");
    
    public MainGame(){
        frame = new Frame(WIDTH, HEIGHT, TITLE, this);
        this.handler = new Handler();
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard(handler));
        
        
        
        // add Start Button
        handler.add(start);
        handler.add(exit);
        
        // add tank image
        handler.add(tankOnStart);
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
        // need to convert point to an origin at 0,0
        
        // get resolution
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth(),
                height = gd.getDisplayMode().getHeight();
        mouseX = funct.map(mouseX, 0, width, -width/2, width/2);
        mouseY = funct.map(mouseY, 0, height, -height/2, height/2);


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
        super.paint(g);
        
        g.setColor(new Color(210,180,140)); // beige
        g.fillRect(-WIDTH/2, -HEIGHT/2, WIDTH, HEIGHT);
        
        if(ControlScreen.startScreen){
            g.drawImage(funct.getImageFromName("background.png"), -WIDTH/4, -HEIGHT/2, null);

            Font f = g.getFont();
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            g.setColor(Color.green);
            g.drawString("Tanks", 0, -250);
            g.setFont(f);
        }
        
        if(ControlScreen.controlScreen){
            Font f = g.getFont();
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            g.setColor(Color.green);
            g.drawString("Controls", 0, -250);
            g.setFont(f);
        }
        
        // render all gameobjects
        handler.render(g);
        g.dispose();
        bs.show();
        
        if(controlScreen == null){
            controlScreen = new ControlScreen(g, handler);
        }
    }
    
    public static void main(String args[]){
        new MainGame();
    }

}

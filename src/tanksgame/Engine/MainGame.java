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
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.SwingUtilities;
import tanksgame.Input.Keyboard;
import tanksgame.Input.Mouse;
import tanksgame.Maps.ConvertTextToMap;
import tanksgame.Objects.Button;
import tanksgame.Objects.ID;
import tanksgame.Objects.InvisibleWall;
import tanksgame.Objects.Map;
import tanksgame.Objects.Player;
import tanksgame.Objects.VisibleWall;
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
    public static boolean updatePlayer = false;
    
    // Map variables what map they are on
    public static int mapCount = 1;
    
    // Mouse Variables
    public static double mouseX = 0, mouseY = 0;
    public static int mouseButton = 0;
    
    // classes
    public static Handler handler;
    public static UseFulFunctions funct = new UseFulFunctions();
    public Frame frame;
    public static ControlScreen controlScreen = null;
    public ConvertTextToMap getMap = new ConvertTextToMap();
    
    // Buttons
    public static Button start = new Button(10, 100, 300, 50, ID.Button, null, Color.blue, "Start"),
            exit = new Button(10, 200, 300, 50, ID.Button, null, Color.green, "Exit"),
            play = new Button(10, 300, 250, 50, ID.Bullet, null, Color.red, "Play!");
    
    // GameObjects
    public static Player player = new Player(WIDTH/2, HEIGHT/2, 90, 142, ID.Tank, "");
    
    // Invisible Walls
    public static InvisibleWall top = new InvisibleWall(0, 0, WIDTH, 10, ID.Wall, "top"),
            bottom = new InvisibleWall(0, HEIGHT, WIDTH, 10, ID.Wall, "bottom"),
            left = new InvisibleWall(0, 0, 10, HEIGHT, ID.Wall, "left"),
            right = new InvisibleWall(WIDTH, 0, 10, HEIGHT, ID.Wall, "right");
    
    // Maps
        // Visible Walls In Maps
    public static Map map1 = null;
        
        
    
    
    public MainGame(){
        frame = new Frame(WIDTH, HEIGHT, TITLE, this);
        this.handler = new Handler();
        addMouseListener(new Mouse());
        addKeyListener(new Keyboard(handler));
        
        
        
        // add Start Button
        handler.add(start);
        handler.add(exit);
        
        // add Invisible Walls
//        handler.add(top);
//        handler.add(bottom);
//        handler.add(left);
//        handler.add(right);
        
        // add visible walls to map1
//        map1.addWall(0, 0, (int)WIDTH, 20, "top");
//        map1.addWall(0, 0, 20, (int)HEIGHT, "left");
//        map1.addWall((int)WIDTH-20, 0, 20, (int) HEIGHT, "right");
//        map1.addWall(0, (int) HEIGHT-40, (int)WIDTH, 20, "bottom");
        map1 = getMap.convertTextToMap(getMap.getText("exampleMap"));
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
//        mouseX = funct.map(mouseX, 0, width, 0, WIDTH);
//        mouseY = funct.map(mouseY, 0, height, 0, HEIGHT);
        Point mousePos = new Point((int)mouseX, (int)mouseY);
        SwingUtilities.convertPointFromScreen(mousePos, this);
        mouseX = mousePos.x;
        mouseY = mousePos.y;
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
        
        
        g.setColor(new Color(210,180,140)); // beige
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        if(ControlScreen.startScreen){
            g.drawImage(funct.getImageFromName("background.png"), WIDTH/5, HEIGHT/8, null);

            Font f = g.getFont();
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            g.setColor(Color.green);
            g.drawString("Tanks", WIDTH/2, 50);
            g.setFont(f);
        }
        
        if(ControlScreen.controlScreen){
            Font f = g.getFont();
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            g.setColor(Color.green);
            g.drawString("Controls", WIDTH/2, 50);
            g.setFont(f);
        }
        if(ControlScreen.gameScreen){
            updatePlayer(g);
            updatePlayer = false;
             // render map based on map count
            if(mapCount == 1){
                mapCount++;
                map1.addWallsToHandler();
                handler.add(map1);
            }
            
        }
               
        // render all gameobjects
        handler.render(g);
        g.dispose();
        bs.show();
        
        if(controlScreen == null){
            controlScreen = new ControlScreen(g, handler);
        }
    }
    
    public void updatePlayer(Graphics2D g){
        if(updatePlayer = true){
            player.render(g);
        }
    }
    
    public static void updatePlayer(){
        updatePlayer = true;
    }
    
    public static void main(String args[]){
        new MainGame();
    }

}

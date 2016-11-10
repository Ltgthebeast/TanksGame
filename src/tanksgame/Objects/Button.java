/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class Button extends GameObject{

    public int width, height;
    public String text;
    public Color c;
    
    public Button(int x, int y, int width, int height, ID id, ImageIcon image, Color c, String text) {
        super(x, y+height, 0, 0, id, text);
        this.width = width;
        this.height = height;
        this.c = c;
        this.text = text;
    }   
    
    @Override
    public void render(Graphics2D g) {
       // draw the rectangle but have a hover over function
      boolean within = new Rectangle((int)x, (int)y, width, height).contains(MainGame.mouseX, MainGame.mouseY);
//        System.out.println("mouseX|"+MainGame.mouseX);
//        System.out.println("mouseY|"+MainGame.mouseY);
       if(within){
           // hovering over button
           g.setColor(new Color(c.getRed()/2, c.getGreen()/2, c.getBlue()/2));
       }else{
           g.setColor(c);
       }
       g.fillRect((int)x, (int)y, width, height);
       g.setColor(Color.BLACK);
       Font org = g.getFont();
       g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
       g.drawString(text, (int)x+(width/2)-(text.length()*4), (int)y+(height/2));
       g.setFont(org);
       
    }

    @Override
    public void tick() {        
        if(collision(null)){
            if(MainGame.mouseButton == 1){
                switch (text){
                    
                    case "Start":
                        // move to controls screen
                        MainGame.controlScreen.Controls();
                        break;
                    
                    case "Exit":
                        System.exit(3);
                        break;
                     
                    case "Play!":
                        // move to actual game
                        MainGame.controlScreen.Game();
                        break;
                        
                    default:
                        break;
                }
            }
        }
        
        
        x+=velX;
        y+=velY;
    }

    @Override
    public boolean collision(GameObject obj) {
        boolean within = new Rectangle((int)x, (int)y, width, height).contains(MainGame.mouseX, MainGame.mouseY);
        return within;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class Button extends GameObject{

    public int width, height;
    public Color c;
    
    public Button(int x, int y, int width, int height, ID id, Image image, Color c) {
        super(x-width, y-height, 0, 0, id, image);
        this.width = width;
        this.height = height;
        this.c = c;
    }   
    
    @Override
    public void render(Graphics2D g) {
       // draw the rectangle but have a hover over function
       boolean withinX = MainGame.funct.withInRange(MainGame.mouseX, x, x+width),
               withinY = MainGame.funct.withInRange(MainGame.mouseY, y, y+height);
       
       System.out.println("Within x|"+withinX);
       System.out.println("Within y|"+withinY);
       if(withinX && withinY){
           // hovering over button
           g.setColor(new Color(c.getRed()/2, c.getGreen()/2, c.getBlue()/2));
       }else{
           g.setColor(c);
       }
       g.fillRect(x, y, width, height);
       
    }

    @Override
    public void tick() {
        
    }
    
}

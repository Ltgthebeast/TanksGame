/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
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
      boolean within = new Rectangle(x, y, width, height).contains(MainGame.mouseX, MainGame.mouseY);
       
       if(within){
           // hovering over button
           g.setColor(new Color(c.getRed()/2, c.getGreen()/2, c.getBlue()/2));
       }else{
           g.setColor(c);
       }
       g.fillRect(x, y, width, height);
       g.setColor(Color.BLACK);
       Font org = g.getFont();
       g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
       g.drawString(text, x+(width/2)-(text.length()*4), y+(height/2));
       g.setFont(org);
       
    }

    @Override
    public void tick() {
//        System.out.println("x|"+x);
//        System.out.println("y|"+y);
//        System.out.println("------");
        x+=velX;
        y+=velY;
    }
    
}

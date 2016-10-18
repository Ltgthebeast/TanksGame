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
       // need to convert all of them with 0 at the origin 
       // draw the rectangle but have a hover over function
       
       g.setColor(c);
       g.fillRect(x, y, width, height);
       System.out.println(x+"|"+y);
    }

    @Override
    public void tick() {
        
    }
    
}

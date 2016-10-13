/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author LGarceau
 */
public abstract class GameObject {
    
    public abstract void render(Graphics g);
    public abstract void tick();
    
    protected int x, y, velX, velY;
    protected ID id;
    protected Image image;
    
    
    
}

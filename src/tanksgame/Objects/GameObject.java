/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author LGarceau
 */
public abstract class GameObject {
    
    public GameObject(int x, int y, int velX, int velY, ID id, ImageIcon image){
       this.x = x;
       this.y = y;
       this.velX = velX;
       this.velY = velY;
       this.id = id;
       this.image = image;        
    }
    
    public abstract void render(Graphics2D g);
    public abstract void tick();
    
    protected int x, y, velX, velY;
    protected ID id;
    protected ImageIcon image;
    
    public ID getID(){
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    
    
}

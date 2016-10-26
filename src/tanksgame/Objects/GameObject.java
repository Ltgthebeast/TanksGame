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
    
    public GameObject(double x, double y, double velX, double velY, ID id, String image){
       this.x = x;
       this.y = y;
       this.velX = velX;
       this.velY = velY;
       this.id = id;
       this.image = image;        
    }
    
    public abstract void render(Graphics2D g);
    public abstract void tick();
    
    protected double x, y;
    protected double velX, velY;
    protected ID id;
    protected String image;
    
    public ID getID(){
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public String getImage() {
        return image;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}

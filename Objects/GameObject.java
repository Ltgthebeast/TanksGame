/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author LGarceau
 */
public abstract class GameObject {
    
    public GameObject(double x, double y, double width, double height, ID id, String image){
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
       this.id = id;
       this.image = image;        
    }
    
    public abstract void render(Graphics2D g);
    public abstract void tick();
    
    protected double x, y, height, width;
    protected double velX, velY;
    protected ID id;
    protected String image;
    
    public abstract boolean collision(GameObject obj);

    public int getHeight() {
        return  (int)height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWidth() {
        return (int)width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
      
    public Rectangle getBounds(){
        return new Rectangle((int)this.x, (int)this.y-30 , (int)this.width, (int)this.height);
    }
    
    public ID getID(){
        return id;
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int) y;
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

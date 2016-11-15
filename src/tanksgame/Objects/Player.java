/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import tanksgame.Engine.MainGame;

/**
 *
 *  two images 
 * one is the tank
 * one is the barrel
 * barrel angle is determined by the position of the mouse
 * 
 * @author LGarceau
 */
public class Player extends GameObject{

    public double canAngle = 0;
    public BufferedImage can = MainGame.funct.getImageFromName("tankCan.png"),
            tank = MainGame.funct.getImageFromName("tank30.png");
    public boolean colliding = false;
    
    public Player(int x, int y, double velX, double velY, ID id, String image) {
        super(x, y, velX, velY, id, image);
    }

    
    @Override
    public void render(Graphics2D g) {
//        System.out.println("angle|"+angle);
        
        
        can = MainGame.funct.getImageFromName("tankCan.png");
        tank = MainGame.funct.getImageFromName("tank30.png");
        
        
        double  xCord = MainGame.mouseX-MainGame.player.x,
                yCord = MainGame.mouseY-MainGame.player.y;
     
        canAngle = Math.atan(-xCord/yCord);
        if(yCord > 0){
            canAngle += Math.PI;
        }
        
//        System.out.println("angle|"+Math.toDegrees(canAngle));
//        System.out.println("mouseX|"+MainGame.mouseX);
//        System.out.println("mouseY|"+MainGame.mouseY);
        double xConstant = 22, yConstant = 52;
        g.drawImage(tank, (int)(x-tank.getWidth()/2), (int)y-tank.getHeight()/2, null);
        g.rotate(canAngle, (int)(x-can.getWidth()/2)+xConstant, (int)y-can.getHeight()/2+yConstant);
        g.drawImage(can, (int)(x-tank.getWidth()/2)+22, (int)y-tank.getHeight()/2+12, null);
        g.rotate(-canAngle, (int)(x-can.getWidth()/2)+xConstant, (int)y-can.getHeight()/2+yConstant);
        
        MainGame.funct.drawBounds(g, this);
//        g.drawImage(op.filter(can, ), (int) (x-tank.getWidth()/2)+20, (int) y-tank.getHeight()/2, null);
        
    }
    
     public String getIntersectedWall(){
        String wall = "";
        
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            GameObject temp = MainGame.handler.objs.get(i);
            if(temp.id == ID.Wall){
                if(collision(temp)){
                    return temp.getImage();
                }
            }
        }
        
        return wall;
    }
    
     

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            GameObject obj = MainGame.handler.objs.get(i);
            if(obj.getBounds() != null){
                if(obj.id == ID.Wall){
                    
                    if(collision(obj)){
//                        CharSequence cs = "abcdefghijklmnopqrstuvwxyz";
                        
                       String direction = getDirection();
                        colliding = true;
                        System.out.println("direction|"+direction);
                        
                        // adjusts one direction at a time
                        switch (direction) {
                               case "left":
                                   setX(x+3);
                                   checkCollision(obj);
                                   return;
                               case "right":
                                   setX(x-3);
                                   checkCollision(obj);
                                   return;
                               default:
                                   break; 
                                   
                           }
                       switch(direction){
                           case "forward":
                               setY(y-10);
                               checkCollision(obj);
                               return;
                           case "backward":
                               setY(y+10);
                               checkCollision(obj);
                               return;
                           default:
                               break;
                       }       
                       
                    }

                    
                
                    System.out.println("colliding|"+colliding);
                    
                }                  
            }                
        }        
    }
        
    public void checkCollision(GameObject obj){
        if(!collision(obj)){
                        colliding = false;
//                        velX = 0;
//                        velY = 0;
                    }  
    }
    
    public String getDirection(){
        String direction = "none";
        
        if(this.velX > 0){
            // right
            return "right";
        }
        else if(this.velX < 0){
            // left
            return "left";
        }        
        if(this.velY > 0){
            // forward
            return "forward";
        }
        else if(this.velY < 0){
            // backward
            return "backward";
        }
        return direction;
    }
    
    
    @Override
    public boolean collision(GameObject obj) {
        Rectangle thisRect = this.getBounds(),
                objRect = obj.getBounds();
        if(thisRect.intersects(objRect)){
            System.out.println("colliding");
        }
        return thisRect.intersects(objRect);
    }

    @Override
    public Rectangle getBounds() {
        
        Rectangle r = new Rectangle((int)(this.x-(this.width/2)), (int)(this.y-(this.height/2)) , (int)this.width, (int)this.height);
        return r;
    }

   
    
}

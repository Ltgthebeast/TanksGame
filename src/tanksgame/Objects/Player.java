/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

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

    public static int angle = 0;
    public BufferedImage can = MainGame.funct.getImageFromName("tankCan.png"),
            tank = MainGame.funct.getImageFromName("tank0.png");
    
    public Player(int x, int y, double velX, double velY, ID id, String image) {
        super(x, y, velX, velY, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        System.out.println("angle|"+angle);
        if(angle >= 360){
            angle-=360;
        }
        if(angle < 0){
            angle+=360;
        }
        
        can = MainGame.funct.getImageFromName("tankCan.png");
        tank = MainGame.funct.getImageFromName("tank"+angle+".png");
        AffineTransform aft = AffineTransform.getRotateInstance(Math.toRadians(-90), (x-tank.getWidth()/2), y-tank.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(aft, AffineTransformOp.TYPE_BILINEAR);
        
        
        g.drawImage(tank, (int)(x-tank.getWidth()/2), (int)y-tank.getHeight()/2, null);
        g.drawImage(op.filter(can, null), (int) (x-tank.getWidth()/2)+20, (int) y-tank.getHeight()/2, null);
    }
    
     public String getIntersectedWall(){
        String wall = "";
        
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            GameObject temp = MainGame.handler.objs.get(i);
            if(collision(temp)){
                wall = temp.getImage();
                break;
            }            
        }
        
        return wall;
    }

    @Override
    public void tick() {
        
        
        x+=velX;
        y+=velY;
        
//        System.out.println("velX |"+velX);
//        System.out.println("velY |"+velY);
//        System.out.println("angle |"+angle);
//        System.out.println("x|"+x);
//        System.out.println("y|"+y);
    }

    @Override
    public boolean collision(GameObject obj) {
        Rectangle thisRect = new Rectangle((int)this.x-tank.getWidth()/2, (int)this.y-tank.getHeight()/2, (int)this.width, (int)this.height),
                objRect = new Rectangle((int)obj.x, (int)obj.y, (int)obj.width, (int)obj.height);
        
        return thisRect.intersects(objRect);
    }
    
    
    
}

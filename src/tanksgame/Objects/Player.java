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
 * @author LGarceau
 */
public class Player extends GameObject{

    public static int angle = 0;
    
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
        BufferedImage img = MainGame.funct.getImageFromName("tank"+angle+".png");
        
        g.drawImage(img, (int)x-(img.getWidth() / 2), (int)y-(img.getHeight() / 2), null);
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
        Rectangle thisRect = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.height),
                objRect = new Rectangle((int)obj.x, (int)obj.y, (int)obj.width, (int)obj.height);
        
        return thisRect.intersects(objRect);
    }
    
    
    
}

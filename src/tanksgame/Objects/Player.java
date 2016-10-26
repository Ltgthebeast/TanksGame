/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class Player extends GameObject{

    public static double angle = 0;
    
    public Player(int x, int y, double velX, double velY, ID id, String image) {
        super(x, y, velX, velY, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage img = MainGame.funct.getImageFromName("tank.png");
        AffineTransform aft = AffineTransform.getScaleInstance(200, 250);
        
        // Rotation information

        double rotationRequired = Math.toRadians (angle);
        double locationX = img.getWidth() / 2;
        double locationY = img.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        // Drawing the rotated image at the required drawing locations
        g.drawImage(op.filter(img, null), (int)x, (int)y, null);
        
    }

    @Override
    public void tick() {
        if(angle >= 360){
            angle-=360;
        }
        if(angle != 0){
            x += Math.cos(angle) * (velX + Math.sin(angle))  * velX;
            y -= -Math.cos(angle) * (velY + Math.sin(angle)) * velY;
            /*
            posX += Math.cos(rotation) *  forwardSpeed + Math.sin(rotation) * strafeSpeed;
            posY -= -Math.cos(rotation) * strafeSpeed + Math.sin(rotation) * forwardSpeed;
            */
        }else{
            x+=velX;
            y+=velY;
        }
        System.out.println("velX |"+velX);
        System.out.println("velY |"+velY);
        System.out.println("angle |"+angle);
        
    }
    
}

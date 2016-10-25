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
        if(angle != 0){
            AffineTransform aft = AffineTransform.getRotateInstance(Math.toRadians(angle), x, y);
            AffineTransformOp op = new AffineTransformOp(aft, AffineTransformOp.TYPE_BILINEAR);
            g.drawImage(op.filter(img, null), x, y, null);
        }else{
            g.drawImage(img, x, y, null);
        }
        
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }
    
}

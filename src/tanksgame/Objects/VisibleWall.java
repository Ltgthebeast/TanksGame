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
import java.awt.image.BufferedImageOp;
import tanksgame.Engine.MainGame;
import tanksgame.lib.Scalr;

/**
 *
 * @author Luke T Garceau
 */
public class VisibleWall extends GameObject{

    public VisibleWall(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage image = MainGame.funct.getImageFromName("wall.png"),
                scaled;
//        scaled = Scalr.resize(image, (int) width, (int) height, Scalr.OP_ANTIALIAS);
        
        scaled = MainGame.funct.getScaledImage(image, (int) width, (int) height, (int) x, (int) y);
        System.out.println(scaled.getWidth()+"|"+scaled.getHeight());
        g.drawImage(scaled, (int)x, (int)y, null);
                
        
    }

    @Override
    public void tick() {
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

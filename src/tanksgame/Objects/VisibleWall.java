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

        int w = image.getWidth(),
                h = image.getHeight();
        
        double scaleX = width/w,
                scaleY = height/h;
        
        scaled = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform aft = new AffineTransform();
        aft.scale(scaleX, scaleY);
        
        AffineTransformOp scaleOp = new AffineTransformOp(aft, AffineTransformOp.TYPE_BILINEAR);
        scaled = scaleOp.filter(image, scaled);
        
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

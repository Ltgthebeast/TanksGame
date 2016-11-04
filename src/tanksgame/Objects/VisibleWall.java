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
                scaled = MainGame.funct.getScaledImage(image, (int) width, (int) height);
//        scaled = Scalr.resize(image, Scalr.Method.BALANCED, width, height);
//        scaled = MainGame.funct.getScaledImage(image, (int) width, (int) height, (int) x, (int) y);
        scaled = MainGame.
        g.drawImage(scaled, (int)x, (int)y, null);
        System.out.println(scaled.getHeight()+"|"+scaled.getWidth());
        
    }

    @Override
    public void tick() {
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.awt.Image;
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
        BufferedImage scaled = MainGame.funct.getImageFromName("wall.png");
//        scaled = MainGame.funct.getScaledImage(scaled, (int) width, (int) height);
        int amtWidth =(int) (width / scaled.getWidth()+.5);
        for(int i = 0; i < )
//        g.drawImage(scaled, (int)x, (int)y, null);
//        System.out.println(scaled.getHeight()+"|"+scaled.getWidth());
        
    }

    @Override
    public void tick() {
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

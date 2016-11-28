/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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
    public Rectangle getBounds(){
        Rectangle r = new Rectangle((int) this.x, (int) this.y, (int) this.width, (int) this.height);
        return r;
    }
    
    
    
    @Override
    public void render(Graphics2D g) {
        
        BufferedImage scaled = MainGame.funct.getImageFromName("wall.png");
        
        if(height < scaled.getHeight()){
            scaled = scaled.getSubimage(0, 0, scaled.getWidth(), (int) height);
        }else if(width < scaled.getWidth()){
            scaled = scaled.getSubimage(0, 0, (int) width, scaled.getHeight());
        }
        
        int amtWidth =(int) (width / scaled.getWidth()+.5);
        for(int i = 0; i < amtWidth; i++){
            g.drawImage(scaled, (int)x+(i*scaled.getWidth()) , (int) y, null);
        }
        int amtHeight = (int) (height / scaled.getHeight()+.5);
        for(int i = 0; i < amtHeight; i++){
            g.drawImage(scaled, (int)x, (int) y+(i*scaled.getHeight()), null);
        }
    }

    @Override
    public void tick() {
    }
    

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

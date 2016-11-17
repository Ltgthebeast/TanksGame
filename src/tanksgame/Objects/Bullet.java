/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import tanksgame.Engine.MainGame;

/**
 *
 * @author Luke T Garceau
 */
public class Bullet extends GameObject{
    
    public double angle;
    public Bullet(double x, double y, double width, double height, ID id, String image, double angle) {
        super(x, y, width, height, id, image);
        this.angle = angle;
    }

    @Override
    public void render(Graphics2D g) {
      
        g.rotate(angle, x, y);
//        g.setColor(Color.BLACK);
//        g.drawLine((int)x,(int) y,(int)x+MainGame.player.can.getWidth(),(int) y+MainGame.player.can.getHeight());
        g.drawImage(MainGame.funct.getImageFromName("bullet.png"), (int) x, (int) y, null);
        g.rotate(-angle, x, y);
    }

    @Override
    public void tick() {
        x += velX;
        y += -velY;
        if(collision(MainGame.bottom) || collision(MainGame.top) || collision(MainGame.left) || collision(MainGame.right)){
            MainGame.handler.remove(this);
        }
    }

    @Override
    public boolean collision(GameObject obj) {
        
        return obj.getBounds().intersects(this.getBounds());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle ((int)x,(int) y, (int)width, (int)height);
    }
    
    
    
}

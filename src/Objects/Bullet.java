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
        g.drawImage(MainGame.funct.getScaledImage(MainGame.funct.getImageFromName("bullet.png"), (int)(this.getWidth()*.75), (int)(this.getHeight()*.75)), (int) x, (int) y, null);
        g.rotate(-angle, x, y);
//        MainGame.funct.drawBounds(g, this);
    }

    @Override
    public void tick() {
        x += velX;
        y += -velY;
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            if(MainGame.handler.objs.get(i).getID() == ID.Wall){
                if(collision(MainGame.handler.objs.get(i))){
                    MainGame.handler.remove(this);
                }
            }
        }
    }

    @Override
    public boolean collision(GameObject obj) {
        
        return obj.getBounds().intersects(this.getBounds());
    }

    @Override
    public Rectangle getBounds() {
        Rectangle bounds = new Rectangle ((int)(x-width),(int) (y-10), (int)width, (int)10);
//        int x = (int) (Math.sin(Math.toRadians(MainGame.player.canAngle))*Math.sqrt(Math.pow(this.getWidth(), 2) + Math.pow(this.getWidth(), 2))),
//                y = (int) (Math.cos(Math.toRadians(MainGame.player.canAngle))*Math.sqrt(Math.pow(this.getHeight(), 2) + Math.pow(this.getHeight(), 2)));
        /*
         sin x = o/h
         cos x = a/h
        */
        
        return bounds;
    }
    
    
    
}

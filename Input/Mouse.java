/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Input;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import tanksgame.Engine.MainGame;
import tanksgame.Objects.Bullet;
import tanksgame.Objects.GameObject;
import tanksgame.Objects.ID;
import tanksgame.Objects.Player;
import tanksgame.Screens.ControlScreen;

/**
 *
 * @author LGarceau
 */
public class Mouse implements MouseListener, MouseMotionListener{
    
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
       MainGame.mouseButton = e.getButton();
       if(e.getButton() == 1){
       // left mouse means fire bullet
       double angle = Math.toDegrees(MainGame.player.canAngle);
            if(ControlScreen.gameScreen){
<<<<<<< Upstream, based on origin/fixedOrigin
                if(angle < 0){
                    angle+=360;
                }
//                System.out.println("bullet angle|"+angle);
                double x =26*Math.cos(angle),
                        y = 97*Math.sin(angle);
                
                Bullet bullet = new Bullet(MainGame.player.getX(), MainGame.player.getY(), 9, 40, ID.Bullet, "", MainGame.player.canAngle);
                
=======
                int x = (MainGame.player.getX()-((MainGame.player.can.getWidth()/4)-10)-25),
                        y = (MainGame.player.getY() - ((MainGame.player.can.getHeight()/4))-25);
                Bullet bullet = new Bullet(x, y, 9, 40, ID.Bullet, "", MainGame.player.canAngle);
>>>>>>> 8cde427 need to fix rotation of the cannon barrel
                MainGame.handler.add(bullet);
                // need to get speed based off angle
                System.out.println("Can Center X|"+MainGame.player.can.getWidth()/4);
                System.out.println("Can Center Y|"+MainGame.player.can.getHeight()/4);

                System.out.println("x:"+bullet.getX());
                System.out.println("y:"+bullet.getY());
                double velY = Math.cos(MainGame.player.canAngle) * 5,
                        velX = Math.sin(MainGame.player.canAngle) * 5;
                bullet.setVelX(velX);
                bullet.setVelY(velY);
            }
       }
       // 1 is left, 2 is middle, 3 is right
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       MainGame.mouseButton = 0;
       // 1 is left, 2 is middle, 3 is right
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      
    }
    
}

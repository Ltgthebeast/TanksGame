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
            if(ControlScreen.gameScreen){
                int x = (MainGame.player.getX()-((MainGame.player.can.getWidth()/4)-10)-25),
                        y = (MainGame.player.getY() - ((MainGame.player.can.getHeight()/4))-25);
                System.out.println("x|"+x);
                System.out.println("y|"+y);
                
                double angle = MainGame.player.canAngle;
                double canXConstant = 123*Math.cos(Math.toRadians(90-angle)), canYConstant = 51*Math.sin(Math.toRadians(90-angle));
                // fix angle 
                
               
                
                Bullet bullet = new Bullet(x+canXConstant+26, y+canYConstant-49, 9, 40, ID.Bullet, "", angle);
                
                MainGame.handler.add(bullet);
                // need to get speed based off angle
                System.out.println("canX|"+(canXConstant+26));
                System.out.println("canY|"+(canYConstant-49));
//                System.out.println("Can Center X|"+MainGame.player.can.getWidth()/4);
//                System.out.println("Can Center Y|"+MainGame.player.can.getHeight()/4);
//
//                System.out.println("x:"+bullet.getX());
//                System.out.println("y:"+bullet.getY());
                double velY = Math.cos(angle) * 5,
                        velX = Math.sin(angle) * 5;
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

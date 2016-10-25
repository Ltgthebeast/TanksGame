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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class KeyBoard implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':
                // move forward
                MainGame.start.setVelY(10);
                break;
            case 's':
                // move down
                MainGame.start.setVelY(-10);
                break;
            case 'a':
                // move left
                MainGame.start.setVelX(-10);
                break;
            case 'd':
                // move right
                MainGame.start.setVelX(10);
                break;    
            default:
                break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w':
                // move forward
                MainGame.start.setVelY(0);
                break;
            case 's':
                // move down
                MainGame.start.setVelY(0);
                break;
            case 'a':
                // move left
                MainGame.start.setVelX(0);
                break;
            case 'd':
                // move right
                MainGame.start.setVelX(0);
                break;    
            default:
                break;
            
        }
    }
    
}

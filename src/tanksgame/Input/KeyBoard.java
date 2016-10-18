/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            case 'W':
                // move forward
                break;
            
            
            default:
                break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import tanksgame.Engine.Handler;
import tanksgame.Engine.MainGame;
import tanksgame.Objects.GameObject;
import tanksgame.Objects.ID;
import tanksgame.Objects.Player;

/**
 *
 * @author LGarceau
 */
public class Keyboard extends KeyAdapter{
    
    public Handler handler;
    public int x = 0, y = 0;
    public Keyboard(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){
        //System.out.println(e.getKeyChar());
        for(int i = 0; i < handler.objs.size(); i++){
            GameObject temp = handler.objs.get(i);
            if(temp.getID() == ID.Tank){
                if(!MainGame.player.colliding){
                    int code = e.getKeyCode();
                    // set movement
                    switch (code) {
                        case KeyEvent.VK_W:
                            y = -2;
                            break;
                        case KeyEvent.VK_S:
                            y = 2;
                            break;
                        case KeyEvent.VK_A:
                            x = -2;
                            break;
                        case KeyEvent.VK_D:
                            x = 2;
                            break;
                        default:
                            break;
                    }
                    temp.setVelX(x);
                    temp.setVelY(y);
                }
            }
        }
    }
    
    
    
    public void keyReleased(KeyEvent e){
         for(int i = 0; i < handler.objs.size(); i++){
            GameObject temp = handler.objs.get(i);
            
            if(temp.getID() == ID.Tank){
                
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        y = 0;
                        break;
                    case KeyEvent.VK_S:
                        y = 0;
                        break;
                    case KeyEvent.VK_A:
                        x = 0;
                        break;
                    case KeyEvent.VK_D:
                        x = 0;
                        break;
                    default:
                        break;
                }
                temp.setVelX(0);
                temp.setVelY(0);
                
            }
        }
    }
    
}

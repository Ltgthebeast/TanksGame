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
    
    public Keyboard(Handler handler){
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e){
        //System.out.println(e.getKeyChar());
        for(int i = 0; i < handler.objs.size(); i++){
            GameObject temp = handler.objs.get(i);
            if(temp.getID() == ID.Tank){
                int code = e.getKeyCode();
                if(code == KeyEvent.VK_W){
                    temp.setVelY(-2);
                }
                if(code == KeyEvent.VK_S){
                    temp.setVelY(2);
                }
                if(code == KeyEvent.VK_A){
                    temp.setVelX(-2);
                }
                if(code == KeyEvent.VK_D){
                    temp.setVelX(2);
                }
                if(code == KeyEvent.VK_Q){
                    // rotate left
                    Player.angle -= 10;
                }
                if(code == KeyEvent.VK_E){
                    // rotate right 
                    Player.angle += 10;
                }
                
                
                
            }
        }
    }
    
    
    
    public void keyReleased(KeyEvent e){
         for(int i = 0; i < handler.objs.size(); i++){
            GameObject temp = handler.objs.get(i);
            
            if(temp.getID() == ID.Tank){
                
                if(e.getKeyCode() == KeyEvent.VK_W){
                    temp.setVelY(0);
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    temp.setVelY(0);
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    temp.setVelX(0);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    temp.setVelX(0);
                }
                if(e.getKeyCode() == KeyEvent.VK_Q){
                    Player.angle += 0;                            
                }
                if(e.getKeyCode() == KeyEvent.VK_E){
                    Player.angle += 0;
                }
                
            }
        }
    }
    
}

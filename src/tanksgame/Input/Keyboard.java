/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import tanksgame.Engine.Handler;
import tanksgame.Engine.MainGame;
import tanksgame.Objects.GameObject;
import tanksgame.Objects.ID;

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
            if(temp.getID() == ID.Button){
                if(e.getKeyCode() == KeyEvent.VK_W){
                    temp.setVelY(-10);
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    temp.setVelY(10);
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    temp.setVelX(-10);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    temp.setVelX(10);
                }
                
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
         for(int i = 0; i < handler.objs.size(); i++){
            GameObject temp = handler.objs.get(i);
            if(temp.getID() == ID.Button){
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
                
            }
        }
    }
    
}

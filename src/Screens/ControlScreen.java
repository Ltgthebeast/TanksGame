/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Screens;

import java.awt.Color;
import java.awt.Graphics2D;
import tanksgame.Engine.Handler;
import tanksgame.Engine.MainGame;
import tanksgame.Objects.Button;
import tanksgame.Objects.ID;

/**
 *
 * @author LGarceau
 */
public class ControlScreen {
    
    public Graphics2D g;
    public Handler h;
    public static boolean startScreen = true, controlScreen = false, pauseScreen = false, gameScreen = false, endScreen = false;
    
    public ControlScreen(Graphics2D g, Handler handler){
        this.g = g;
        h = handler;
    }
    
    public void Controls(){
        startScreen = false;
        controlScreen = true;
        h.remove(MainGame.start);
        h.remove(MainGame.exit);
        
        h.add(MainGame.play);
    }
    
    public void Game(){
        controlScreen = false;
        gameScreen = true;
        h.remove(MainGame.play);
        h.add(MainGame.player);
    }
    
   
    
}

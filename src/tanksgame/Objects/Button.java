/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics;
import java.awt.MouseInfo;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class Button extends GameObject{

    public Button(int x, int y, int velX, int velY, )
    
    @Override
    public void render(Graphics g) {
       
    }

    @Override
    public void tick() {
        MainGame.mouseY = MouseInfo.getPointerInfo().getLocation().y;
        MainGame.mouseX = MouseInfo.getPointerInfo().getLocation().x;         
        System.out.println("Mouse x: "+MainGame.mouseX+" Mouse y: "+MainGame.mouseY+" Button 1: "+MainGame.mouse1Down+" Button 2: "+MainGame.mouse2Down);
    }
    
}

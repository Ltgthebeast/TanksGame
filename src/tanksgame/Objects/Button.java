/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class Button extends GameObject{

    public Button(int x, int y, int velX, int velY, ID id, Image image) {
        super(x, y, velX, velY, id, image);
    }   
    
    @Override
    public void render(Graphics g) {
       
    }

    @Override
    public void tick() {
        
    }
    
}

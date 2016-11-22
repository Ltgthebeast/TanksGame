/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import tanksgame.Engine.MainGame;

/**
 *
 * @author Luke T Garceau
 */
public class InvisibleWall extends GameObject{

    public int updateTime = 2;
    
    public InvisibleWall(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        // no graphics for inivisble wall
//        g.setColor(Color.blue);
//        g.drawRect((int)x, (int)y, (int)this.width, (int)this.height);
    }

    @Override
    public void tick() {
        
                // move back based on direction
        String direction = MainGame.player.getIntersectedWall();

        if(direction.equals("bottom")){
            // move up
                MainGame.player.setY(MainGame.player.getY()-5);
        }
        if(direction.equals("top")){
            // move down
            MainGame.player.setY(MainGame.player.getY()+5);
        }
        if(direction.equals("left")){
            // move right
            MainGame.player.setX(MainGame.player.getX()+5);
        }
        if(direction.equals("right")){
            // move left
            MainGame.player.setX(MainGame.player.getX()-5);
        }
    }

    
   
    
    @Override
    public boolean collision(GameObject obj) {
        Rectangle thisRect = getBounds(),
            objRect = obj.getBounds();
        
        return thisRect.intersects(objRect);
    }
    
}

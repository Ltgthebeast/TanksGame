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
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            GameObject temp = MainGame.handler.objs.get(i);
            
            if(temp.collision(this) && (temp.getID() != ID.Wall || temp.getID() == ID.Image || temp.getID() == ID.Button)){
                
                // move back based on direction
                String direction = MainGame.player.getIntersectedWall();
                
                if(direction.equals("bottom")){
                    // move up
                    temp.setY(temp.getY()-5);
                }
                if(direction.equals("top")){
                    // move down
                    temp.setY(temp.getY()+5);
                }
                if(direction.equals("left")){
                    // move right
                    temp.setX(temp.getX()+5);
                }
                if(direction.equals("right")){
                    // move left
                    temp.setX(temp.getX()-5);
                }
                
//                temp.setVelX(-temp.getVelX());
//                temp.setVelY(-temp.getVelY());
//                
////                for(int k = 0; k < updateTime; k++){
////                    temp.tick();
////                }
//                temp.setVelX(0);
//                temp.setVelY(0);
            }
        }
    }

    
   
    
    @Override
    public boolean collision(GameObject obj) {
        Rectangle thisRect = getBounds(),
            objRect = obj.getBounds();
        
        return thisRect.intersects(objRect);
    }
    
}

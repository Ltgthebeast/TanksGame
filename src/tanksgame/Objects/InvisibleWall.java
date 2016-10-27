/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import tanksgame.Engine.MainGame;

/**
 *
 * @author Luke T Garceau
 */
public class InvisibleWall extends GameObject{

    public InvisibleWall(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        // no graphics for inivisble wall
    }

    @Override
    public void tick() {
        for(int i = 0; i < MainGame.handler.objs.size(); i++){
            GameObject temp = MainGame.handler.objs.get(i);
            if(collision(temp)){
                if()
            }
        }
    }

    public int getDirectionCollision(GameObject obj){
        // return the direction of the collision
    }
    
    @Override
    public boolean collision(GameObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

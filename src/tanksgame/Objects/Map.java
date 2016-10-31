/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.util.LinkedList;

/**
 *
 * @author Luke T Garceau
 */
public class Map extends GameObject{
    
    public LinkedList<VisibleWall> walls = new LinkedList<VisibleWall>();
    
    public Map(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }
    
    public void addWall(VisibleWall wall){
        walls.add(wall);
    }

    @Override
    public void render(Graphics2D g) {
       for(int i = 0; i < walls.size(); i++){
           walls.get(i).render(g);
       }
    }

    @Override
    public void tick() {
        for(int i = 0; i < walls.size(); i++){
           walls.get(i).tick();
       }
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

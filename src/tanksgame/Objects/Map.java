/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;

/**
 *
 * @author Luke T Garceau
 */
public class Map extends GameObject{

    public Map(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }

    @Override
    public void render(Graphics2D g) {
       // display graphics for map
    }

    @Override
    public void tick() {
        // update anything like check for a collision
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }
    
}

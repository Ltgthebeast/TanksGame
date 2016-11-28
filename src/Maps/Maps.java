/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Maps;

import java.util.LinkedList;
import tanksgame.Objects.ID;
import tanksgame.Objects.VisibleWall;

/**
 *
 * @author LGarceau
 */
public class Maps {
    public LinkedList<VisibleWall> map = new LinkedList<>();
    
    public LinkedList<VisibleWall> getMap(int level){
        switch(level){
            case 1:
                //  x  y   w    h
                add(0, 0, 900, 20);
                add(0, 0, 20, 600);
                add(880, 0, 20, 600);
                add(0, 560, 900, 20);
                // end walls
                add(231, 19, 20, 200);
                add(211, 223, 20, 50);
                add(124, 263, 100, 20);
                // left side
                // right side
                break;
            default:
                break;
        }
        return map;
    }
    
    public void add(int x, int y, int width, int height){
        map.add(wall(x,y,width,height));
    }
    
    public VisibleWall wall(int x, int y, int width, int height){
        return new VisibleWall(x, y, width, height, ID.Wall, "");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import tanksgame.Engine.MainGame;
import java.util.LinkedList;

/**
 *
 * @author Luke T Garceau
 */
public class Map extends GameObject{

    public LinkedList<VisibleWall> walls = new LinkedList<VisibleWall>();
    public boolean rendered = false, render = false;
    
    public Map(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }
    
    public void addWall(int x, int y, int width, int height, String direction){
        walls.add(new VisibleWall(x, y, width, height, ID.Wall, direction));
    }
    
    public void addWalls(LinkedList<VisibleWall> walls){
        for(VisibleWall wall: walls){
            this.walls.add(wall);
        }
    }
    
    public void addWall(VisibleWall e){
        walls.add(e);
    }
    
    public void addWallsToHandler(){
        for(VisibleWall wall: walls){
            MainGame.handler.add(wall);
        }
    }
    
    public void removeWallsFromHandler(){
        for(VisibleWall wall: walls){
            MainGame.handler.remove(wall);
        }
    }
    
    public void renderWalls(){
        render = true;
    }
    
    @Override
    public void render(Graphics2D g) {
       // display graphics for map
       
        for(int i = 0; i < walls.size(); i++){
            walls.get(i).render(g);
        }
       
       if(render){
           if(!rendered){
               for(int i = 0; i < walls.size(); i++){
                   walls.get(i).render(g);
               }
           }
           rendered = true;
       }
    }

    @Override
    public void tick() {
        // update anything like check for a collision
    }

    @Override
    public boolean collision(GameObject obj) {
        return false;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
}

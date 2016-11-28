/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Engine;

import java.awt.Graphics2D;
import java.util.LinkedList;
import tanksgame.Objects.GameObject;

/**
 *
 * @author LGarceau
 */
public class Handler {
    
    public LinkedList<GameObject> objs = new LinkedList<GameObject>();
    
    public void render(Graphics2D g){
        for(int i = 0; i < objs.size(); i++){
            objs.get(i).render(g);
        }
    }
    
    public void tick(){
        for(int i = 0; i < objs.size(); i++){
            objs.get(i).tick();
        }
    }
    
    public void remove(GameObject o){
        for(int i = 0; i < objs.size(); i++){
            if(objs.get(i).equals(o)){
                objs.remove(i);
            } 
        }
    }
    
    public void add(GameObject o){
        objs.add(o);
    }
}

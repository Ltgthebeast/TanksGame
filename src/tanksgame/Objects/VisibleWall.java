/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import tanksgame.Engine.MainGame;

/**
 *
 * @author Luke T Garceau
 */
public class VisibleWall extends GameObject{

   
    
    public VisibleWall(double x, double y, double width, double height, ID id, String image) {
        super(x, y, width, height, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage scaled = MainGame.funct.getImageFromName("wall.png");
        
        if(height < scaled.getHeight()){
            scaled = scaled.getSubimage(0, 0, scaled.getWidth(), (int) height);
        }else if(width < scaled.getWidth()){
            scaled = scaled.getSubimage(0, 0, (int) width, scaled.getHeight());
        }
        
        int amtWidth =(int) (width / scaled.getWidth()+.5);
        for(int i = 0; i < amtWidth; i++){
            g.drawImage(scaled, (int)x+(i*scaled.getWidth()) , (int) y, null);
        }
        int amtHeight = (int) (height / scaled.getHeight()+.5);
        for(int i = 0; i < amtHeight; i++){
            g.drawImage(scaled, (int)x, (int) y+(i*scaled.getHeight()), null);
        }
//        g.drawImage(scaled, (int)x, (int)y, null);
//        System.out.println(scaled.getHeight()+"|"+scaled.getWidth());
        
    }

    @Override
    public void tick() {
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
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Engine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author LGarceau
 */
public class UseFulFunctions {
    
    public double map(double input, double oldMin, double oldMax, double newMin, double newMax){
        return (input - oldMin) * (newMax - newMin) / (oldMax - oldMin) + newMin;
    }
    
    public double clamp(double input, double min, double max){
        if(input > max) return max;
        if(input < min) return min;
        return input;
    }
    
    public boolean withInRange(double input, double realLow, double realHigh){
//        System.out.println("input|"+input);
//        System.out.println("realLow|"+realLow);
//        System.out.println("realHigh|"+realHigh);
        if(input > realLow && input < realHigh) return true;
        return false;
    }
    
    public BufferedImage getImageFromName(String path){
        BufferedImage img = null;
        try{
            img = ImageIO.read(this.getClass().getResource("/Images/"+path));
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return img;
    }
}

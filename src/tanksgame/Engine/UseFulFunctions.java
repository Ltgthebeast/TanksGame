/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Engine;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author LGarceau
 */
public class UseFulFunctions {
    
    public BufferedImage getScaledImage(BufferedImage src, int w, int h, int x, int y){
        int fW = w,
                fH = h;
        
        double factor = 1.0d;
        
        if(src.getWidth() > src.getHeight()){
            factor = ((double) src.getHeight() / (double) src.getWidth());
            fH = (int)(fW * factor);
        }else{
            factor = ((double) src.getWidth() / (double) src.getHeight());
            fW = (int)(fH * factor);
        }
        
        BufferedImage resizedImage = new BufferedImage(fW, fH, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(src, x, y, fW, fH, null);
        g2.dispose();
        return resizedImage;
    }
    
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

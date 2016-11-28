/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.IndexColorModel;
import java.awt.image.RGBImageFilter;
import java.awt.image.WritableRaster;
import java.io.IOException;
import javax.imageio.ImageIO;
import tanksgame.Objects.GameObject;

/**
 *
 * @author LGarceau
 */
public class UseFulFunctions {
    
    public void drawRect(Graphics2D g, Rectangle rect){
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
    
    public void fillRect(Graphics2D g, Rectangle rect){
    	g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
    
    public void drawBounds(Graphics2D g, GameObject obj){
        g.setColor(Color.blue);
        g.drawRect(obj.getBounds().x, obj.getBounds().y, obj.getBounds().width, obj.getBounds().height);
    }
    
    public BufferedImage getScaledImage(BufferedImage img, int w, int h){
        
        int Ow = img.getWidth();
        int Oh = img.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(dimg, 0, 0, w, h, 0, 0, Ow, Oh, null, null);
        g.dispose();
        
        Image tmp = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g = dimg.createGraphics();
        g.drawImage(tmp, 0, 0, null);
        g.dispose();
        
        return dimg;
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

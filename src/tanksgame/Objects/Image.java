/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author LGarceau
 */
public class Image extends GameObject{

    public Image(int x, int y, int velX, int velY, ID id, ImageIcon image) {
        super(x, y, velX, velY, id, image);
    }

    @Override
    public void render(Graphics2D g) {
        java.awt.Image img = image.getImage();
        g.drawImage(img, x, y, null);
    }

    @Override
    public void tick() {
    }
    
}

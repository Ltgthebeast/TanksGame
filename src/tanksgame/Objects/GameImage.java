/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import tanksgame.Engine.MainGame;

/**
 *
 * @author LGarceau
 */
public class GameImage extends GameObject{

    public int width, height;
    
    public GameImage(int x, int y, int width, int height, ID id, String path) {
        super(x, y, 0, 0, id, path);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics2D g) {
        
    }

    @Override
    public void tick() {
    }
    
}

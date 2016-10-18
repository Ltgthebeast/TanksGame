/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Window;

import java.awt.Dimension;
import javax.swing.JFrame;
import tanksgame.Engine.MainGame;
import static tanksgame.Engine.MainGame.mouse;

/**
 *
 * @author LGarceau
 */
public class Frame extends JFrame{
    public JFrame frame;
    
    public Frame(int width, int height, String title, MainGame game){
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
    }
    
}
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import stellarhaven.view.GamePanel;
import stellarhaven.view.resources.ImageResourcePool;
import stellarhaven.view.resources.ResourcePool;

/**
 * Entry point for Stellar Haven the game
 */
public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {    
        // Start main resource loading
        ResourcePool<?> images = new ImageResourcePool();
        int imagePool = ResourcePool.createResourcePool(images);
        
        // Start main game window
        JFrame frame = new JFrame();
        GamePanel gp = new GamePanel();
        frame.add(gp);
        frame.setSize(GamePanel.SCALE * GamePanel.SIZEX, GamePanel.SCALE * GamePanel.SIZEY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();

        frame.setVisible(true);
        gp.startGameThread();
        // Load save files

        // Start User UI
        
    }
}
package stellarhaven;

import javax.swing.JFrame;

import stellarhaven.view.GamePanel;
import stellarhaven.view.resources.AudioResourcePool;
import stellarhaven.view.resources.ImageResourcePool;
import stellarhaven.view.resources.ModelResourcePool;
import stellarhaven.view.resources.ResourcePool;

import java.awt.*;

/**
 * Entry point for Stellar Haven, a game in which you
 * manage a colony of people on a reproductive 
 * terraforming mission
 * 
 * @author William
 */
public class Main {

    public static GamePanel gp;

    /**
     * Entry point main method for program
     */
    public static void main(String[] args) {

        // Start main resource loading
        ResourcePool<?> images = new ImageResourcePool();
        int imagePool = ResourcePool.createResourcePool(images);
        if (imagePool != 0) {
            System.err.println(imagePool + " is not 0");
            System.exit(-1);
        }
        ResourcePool<?> audio = new AudioResourcePool();
        int audioPool = ResourcePool.createResourcePool(audio);
        if (audioPool != 1) {
            System.err.println(audioPool + " is not 1");
            System.exit(-1);
        }
        ResourcePool<?> model = new ModelResourcePool();
        int modelPool = ResourcePool.createResourcePool(model);
        if (modelPool != 2) {
            System.err.println(modelPool + " is not 2");
            System.exit(-1);
        }
        
        
        // Start main game window
        JFrame frame = new JFrame("Stellar Haven");
        gp = new GamePanel();
        frame.add(gp);
        frame.setSize(GamePanel.SCALE * GamePanel.SIZEX, GamePanel.SCALE * GamePanel.SIZEY);
        frame.setPreferredSize(new Dimension(GamePanel.SCALE * GamePanel.SIZEX, GamePanel.SCALE * GamePanel.SIZEY));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();

        gp.startGameThread();
        
        // Load save files

        // Start User UI
        
    }
}
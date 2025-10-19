package stellarhaven;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

import stellarhaven.test.AllTestsSuite;
import stellarhaven.test.TestSuite;
import stellarhaven.view.GamePanel;
import stellarhaven.view.resources.AudioResourcePool;
import stellarhaven.view.resources.ImageResourcePool;
import stellarhaven.view.resources.ModelResourcePool;
import stellarhaven.view.resources.ResourcePool;

public class Main {
    public static GamePanel gp;

    public static void main(String[] args) {
        if (args.length >= 1) {
            if (args[0].equals("--test")) {
                TestSuite allTests = new AllTestsSuite();
                return;
            }
        }


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

        JFrame frame = new JFrame();
        gp = new GamePanel();
        frame.add(gp);
        frame.setSize(768, 768);
        frame.setPreferredSize(new Dimension(768, 768));
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        gp.startGameThread();
    }
}
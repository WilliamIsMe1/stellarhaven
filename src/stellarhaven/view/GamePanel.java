package stellarhaven.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

import stellarhaven.view.scene.Scene;

public class GamePanel extends JPanel implements Runnable {

    private Scene currentScene;

    public static final int SCALE = 6;
    public static final int SIZEX = 128;
    public static final int SIZEY = 128;

    @Override
    public void run() {
        
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,SIZEX*SCALE, SIZEY*SCALE);
        currentScene.draw(g2);
        g2.dispose();
    }

    public void startGameThread() {
        Thread currentThread = new Thread(this);
        currentThread.start();
    }
}
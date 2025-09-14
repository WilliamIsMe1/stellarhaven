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

    public static final int FPS = 60;

    @Override
    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();
            long nextDrawTime = currentTime + 1000 / FPS;

            update();
            repaint();

            if (System.currentTimeMillis() < nextDrawTime) {
                try {
                    Thread.sleep(nextDrawTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    System.err.println("Man I hate runtime errors");
                }
            }
        }
    }

    public void update() {
        currentScene.update();
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
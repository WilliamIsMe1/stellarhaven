package stellarhaven.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

import stellarhaven.view.scene.Scene;

/**
 * This is the class that manages the rendering component of the game, and
 * the linking of the controller to the view. It calls the update function 
 * in sync with the render function, named draw({@link Graphics2D} g2) in 
 * most classes. It relies on a {@link Scene} based architecture and 
 * allows for the passing of a {@link HashMap} object to a new 
 * {@link Scene}, giving it the information necessary to its own
 * initialization through the {@link Scene#initialize(java.util.HashMap)}
 * function.
 * 
 * @author William
 */
public final class GamePanel extends JPanel implements Runnable {

    private Scene currentScene;
    
    /**
     * This is the scale constant that controls the size of a pixel. It is
     * 6x6 right now.
     */
    public static final int SCALE = 6;
    
    /**
     * This is the width of the window in mixels, with each mixel being
     * 6x6 pixels, as per the {@link GamePanel#SCALE} constant.
     */
    public static final int SIZEX = 128;

    /**
     * This is the height of the window in mixels, with each mixel being
     * 6x6 pixels, as per the {@link GamePanel#SCALE} constant.
     */
    public static final int SIZEY = 128;

    /**
     * This is the FPS of the game, with both {@link GamePanel#update()}
     * and {@link GamePanel#paintComponent(Graphics)} being called 60
     * times per second.
     */
    public static final int FPS = 60;

    /**
     * Overriden {@link Runnable#run()} method, executed when {@link GamePanel}
     * is started as a thread. This allows the game to be updated 60 times per
     * second (Refer to {@link GamePanel#FPS}). Uses the sleep method.
     */
    @Override
    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();  // Get current time
            long nextDrawTime = currentTime + 1000 / FPS; // Find next draw time as a timestamp

            // Call necessary functions
            update();
            repaint();

            // If there is time left, sleep. Otherwise, alert the programmer to stupid lag
            if (System.currentTimeMillis() < nextDrawTime) {
                try {
                    Thread.sleep(nextDrawTime - System.currentTimeMillis()); // Sleep for the remainder of time
                } catch (InterruptedException e) {
                    // What clown would multithread this? This should be impossible
                }
            } else {
                System.err.println("Warning: LAG. I'd recommend fixing that."); // Hope this doesn't happen
            }
        }
    }

    /**
     * This function is called once every 60 seconds, and updates the current
     * {@link Scene} by calling {@link Scene#update()}
     */
    public void update() {
        currentScene.update();
    }

    /**
     * This function overrides {@link JPanel#paintComponent(java.awt.Graphics)}
     * 
     * @param g The {@link Graphics} object being passed in to draw on
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,SIZEX*SCALE, SIZEY*SCALE);
        currentScene.draw(g2);
        g2.dispose();
    }

    /**
     * This function starts the game thread
     */
    public void startGameThread() {
        Thread currentThread = new Thread(this);
        currentThread.start();
    }
}
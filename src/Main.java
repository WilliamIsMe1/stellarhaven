import javax.swing.JFrame;

import stellarhaven.view.GamePanel;

public class Main {
    public static void main(String[] args) {
        // Start main resource loading
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
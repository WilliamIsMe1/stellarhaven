package stellarhaven.view.resources.assets;

import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
import stellarhaven.view.GamePanel;
import stellarhaven.view.resources.ResourcePool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MoonBackground extends Background {
    public MoonBackground() {
        super((BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem("/background/moon.png"));
        checkIfNull();
    }

    private void checkIfNull() {
        BufferedImage i = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem("/background/moon.png");
        if (i == null) {
            throw new RuntimeException("MoonBackground image is null");
        }

    }

    @Override
    public void draw(Graphics2D g2, Coord offset) {


        int x = offset.x % (GamePanel.SCALE * GamePanel.SIZEX / 4); // Mod this by the screen size;
        int y = offset.y % (GamePanel.SCALE * GamePanel.SIZEY / 4);
        int sizeX = GamePanel.SCALE * GamePanel.SIZEX / 4;
        int sizeY = GamePanel.SCALE * GamePanel.SIZEY / 4;
        for (int i = -1; i < 5; i++) {
            for (int j = -1; j < 5; j++) {
                g2.drawImage(getBackground(), x + sizeX * i, y + sizeY * j, sizeX, sizeY, null);
            }
        }


    }
}

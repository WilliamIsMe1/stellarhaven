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


        int x = offset.x % (GamePanel.SCALE * GamePanel.SIZEX); // Mod this by the screen size;
        int y = offset.y % (GamePanel.SCALE * GamePanel.SIZEY);
        int sizeX = GamePanel.SCALE * GamePanel.SIZEX;
        int sizeY = GamePanel.SCALE * GamePanel.SIZEY;

        g2.drawImage(getBackground(), x - sizeX, y - sizeY, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x - sizeX, y, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x - sizeX, y + sizeX, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x, y - sizeY, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x, y, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x, y + sizeX, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x + sizeX, y - sizeY, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x + sizeX, y, sizeX, sizeY, null);
        g2.drawImage(getBackground(), x + sizeX, y + sizeX, sizeX, sizeY, null);
    }
}

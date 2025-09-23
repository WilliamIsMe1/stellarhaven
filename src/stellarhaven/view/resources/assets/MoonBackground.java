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
    }

    @Override
    public void draw(Graphics2D g2, Coord offset) {
        Coord transformedOffset;
        int x = offset.x % (GamePanel.SCALE * GamePanel.SIZEX); // Mod this by the screen size;
        int y = offset.y % (GamePanel.SCALE * GamePanel.SIZEY);

        transformedOffset = new Coord(x, y);
        
    }
}

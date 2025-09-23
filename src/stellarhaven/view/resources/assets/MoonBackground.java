package stellarhaven.view.resources.assets;

import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
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
        int x = offset.x; // Mod this by the screen size;
        // TODO: Do the same on the y

    }
}

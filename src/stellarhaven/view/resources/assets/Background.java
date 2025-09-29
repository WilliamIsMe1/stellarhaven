package stellarhaven.view.resources.assets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import stellarhaven.util.Coord;

public abstract class Background {
    private final BufferedImage background;
    protected Background(BufferedImage background) {
        this.background = background;
    }
    public BufferedImage getBackground() {
        return background;
    }
    public abstract void draw(Graphics2D g2, Coord offset);
}

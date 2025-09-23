package stellarhaven.view.resources.assets;

import stellarhaven.view.util.Drawable;

import java.awt.image.BufferedImage;

public abstract class Background implements Drawable {
    private BufferedImage background;
    protected Background(BufferedImage background) {
        this.background = background;
    }
    public BufferedImage getBackground() {
        return background;
    }
}

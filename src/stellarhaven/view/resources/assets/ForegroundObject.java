package stellarhaven.view.resources.assets;

import java.awt.image.BufferedImage;

public class ForegroundObject {

    public ForegroundObject(BufferedImage image, int x, int y) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    private int x;
    private int y;
    private BufferedImage image;
    private int width;
    private int height;
}

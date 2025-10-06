package stellarhaven.view.resources.assets;

import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
import stellarhaven.util.Drawable;
import stellarhaven.util.IsometricUtils;
import stellarhaven.view.scene.WorldScene;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ForegroundObject implements Drawable {

    private Coord parentCoord;

    public ForegroundObject(BufferedImage image, int x, int y) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = x;
        this.y = y;
        this.image = image;
        parentCoord = new Coord(0, 0);
    }
    
    public void updateParentCoord(Coord parentCoord) {
        this.parentCoord = parentCoord;
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
        return IsometricUtils.calculateIsometric(x,y)
                .add(parentCoord)
                .y;
    }

    public int getX() {
        return IsometricUtils.calculateIsometric(x,y)
                .add(parentCoord)
                .x;
    }

    

    private final int x;
    private final int y;
    private final BufferedImage image;
    private final int width;
    private final int height;

    @Override
    public void draw(Graphics2D g2, Coord parentCoord) {
        Coord iso = IsometricUtils.calculateIsometric(x,y);
        var newCoord = parentCoord.add(iso);
        g2.drawImage(image, newCoord.x, newCoord.y, width * Constants.GAME_SCALE, height * Constants.GAME_SCALE, null);
    }
}

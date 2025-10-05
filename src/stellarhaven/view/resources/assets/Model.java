package stellarhaven.view.resources.assets;

import stellarhaven.model.entity.Entity;
import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
import stellarhaven.util.Drawable;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static stellarhaven.view.resources.assets.Model.Type.STATIC;
import static stellarhaven.view.resources.assets.Model.Type.BLOCK;

/**
 * How does this work? I want it to be so that I can place the background
 * walls, the foreground, and the inside elements. The inside elements need
 * positions, and from that we need to determine z indexes. {@link java.lang.Comparable}
 * could help here!
 * <br>
 * <br>
 * Format:
 * <pre>
 * {
 *   "type": "block" // Block type means that it uses foreground, background, and internal objects. Static means a static image.
 *   For block:
 *   "foreground": "/path/to/foreground/texture.png",
 *   "background": "/path/to/background/texture.png",
 *   "objects": [
 *      {
 *          "texture": "/path/to/texture.png",
 *          "x": 3,
 *          "y": 4
 *      }
 *   ]
 *   For static:
 *   "texture": "/path/to/texture.png"
 * }
 * </pre>
 *
 * @author William
 */
public class Model {

    public enum Type {
        BLOCK,
        STATIC
    }

    private final Type type;
    private ArrayList<ForegroundObject> objects = new ArrayList<>(); // Unnecessary if block type is static
    private BufferedImage backgroundTexture; // Also the static image texture
    private BufferedImage foregroundTexture; // Also unnecessary if block is static

    public void draw(Graphics2D g2, ArrayList<Entity> entitiesToDraw, boolean isTransparent, Coord parentCoord) {
        // This would first draw in the Background object, and then draw the foreground object. Likely, a few new things would need to be passed in.
        g2.drawImage(backgroundTexture, parentCoord.x, parentCoord.y, Constants.TILE_SIZE * Constants.GAME_SCALE, Constants.TILE_SIZE * Constants.GAME_SCALE, null);
        if (type == BLOCK) {
            // Here you'd draw foreground objects and entities based on Z index
            ArrayList<Drawable> drawableArrayList = new ArrayList<>(entitiesToDraw);
            drawableArrayList.addAll(objects);

            drawableArrayList.sort();

            g2.drawImage(foregroundTexture, parentCoord.x, parentCoord.y, Constants.TILE_SIZE * Constants.GAME_SCALE, Constants.TILE_SIZE * Constants.GAME_SCALE, null);
        }
    }

    public Model(BufferedImage staticTexture) {
        type = STATIC;
        backgroundTexture = staticTexture;
    }

    public Model(BufferedImage foregroundTexture, BufferedImage backgroundTexture, ArrayList<ForegroundObject> objects) {
        type = BLOCK;
        this.foregroundTexture = foregroundTexture;
        this.backgroundTexture = backgroundTexture;
        this.objects = objects;
    }
}

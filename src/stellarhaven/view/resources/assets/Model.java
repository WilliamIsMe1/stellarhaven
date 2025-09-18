package stellarhaven.view.resources.assets;

import stellarhaven.model.entity.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

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
 *          "y": 4,
 *          "z": 3
 *      }
 *   ]
 *   For static:
 *   "texture": "/path/to/texture.png"
 * }
 * </pre>
 *
 * @author William
 */
public class Model implements Serializable {
    public enum Type {
        BLOCK,
        STATIC
    }

    private ArrayList<ForegroundObject> objects = new ArrayList<>();
    private BufferedImage backgroundTexture; // Also the static image texture
    private BufferedImage foregroundTexture;

    private static final long serialVersionUID = 1L;

    public void draw(Graphics2D g2, ArrayList<Entity> entitiesToDraw) {
        // This would first draw in the Background object, and then draw the foreground object. Likely, a few new things would need to be passed in.

    }
    
    @Override
    private void writeObject(java.io.ObjectOutputStream oos) {

    }

    @Override
    private void readObject(java.io.ObjectInputStreamn ois) {
        
    }
}

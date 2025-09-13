package stellarhaven.view;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;

/**
 * A resource pool for loading and caching images.
 * 
 * Usage:
 * 1. Create an instance of ImageResourcePool.
 * 2. Register instance with {@link ResourcePool#createResourcePool(ResourcePool)} to obtain an ID.
 * 3. Use getItem with the image path to load and cache images.
 * 
 * @author William
 */
public class ImageResourcePool extends ResourcePool<BufferedImage> {

    private HashMap<String, BufferedImage> pool = new HashMap<>();

    /**
     * Creates a new ImageResourcePool. No initialization is
     * actually necessary
     */
    public ImageResourcePool() {}

    /**
     * Retrieves an image from the pool, loading and caching it
     * so as to use it for later
     * 
     * @param path The path to the image resource
     * @return The loaded image, or null if loading failed
     */
    @Override
    public BufferedImage getItem(String path) {
        if (!pool.containsKey(path)) {
            try (InputStream i = getClass().getResourceAsStream(path)) {
                BufferedImage img = javax.imageio.ImageIO.read(i);
                pool.put(path, img);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return pool.get(path);
    }
}

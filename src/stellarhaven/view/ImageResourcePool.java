package stellarhaven.view;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageResourcePool extends ResourcePool {
    private HashMap<String, BufferedImage> pool = new HashMap<>();
    public ImageResourcePool() {

    }
}

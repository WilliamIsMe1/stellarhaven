package stellarhaven.view.scene;

import java.awt.Graphics2D;
import java.util.HashMap;

/**
 * A class representing a scene, with methods to draw and update
 */
public abstract class Scene {

    public abstract void draw(Graphics2D g2);

    public abstract void update();

    public abstract void initialize(HashMap<String,String> properties);

    public abstract void getProperty();
    
}

package stellarhaven.view.scene;

import java.awt.Graphics2D;
import java.util.HashMap;

/**
 * A class representing a scene, with methods to draw and update
 * 
 * @author William
 */
public abstract class Scene {

    /**
     * This function, called 60 times per second, renders the {@link Scene}
     * 
     * @param g2 The {@link Graphics2D} object to link in
     */
    public abstract void draw(Graphics2D g2);

    /**
     * This function, called 60 times per second, updates the {@link Scene}. 
     * TPS might need reduction later, by calling this once every 3 render 
     * ticks, or something like that.
     */
    public abstract void update();

    /**
     * This function should be run before any scene starts rendering, because it
     * initializes the {@link Scene} with the information it should carry from 
     * the last one.
     * 
     * @param properties The information the last scene wants to pass to this one
     */
    public abstract void initialize(HashMap<String,String> properties);

    /**
     * This function retrieves a property of the {@link Scene}
     * 
     * @param key This is the property that the caller is attempting to retrieve
     * @return The value of the property
     */
    public abstract String getProperty(String key);
    
}

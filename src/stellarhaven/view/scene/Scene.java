package stellarhaven.view.scene;

import stellarhaven.util.MouseEventType;
import stellarhaven.util.Pair;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.MouseEvent;

/**
 * A class representing a scene, with methods to draw and update
 * 
 * @author William
 */
public abstract class Scene {

    protected ArrayList<Pair<MouseEvent, MouseEventType>> unprocessedEvents = new ArrayList<>();

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
     * @param numericalProperties The numberical properties the last scene is passing to this one
     */
    public abstract void initialize(HashMap<String,String> properties, HashMap<String,Double> numericalProperties);

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
    

    public abstract double getNumericalProperty(String key);

    public void passMouseEvent(MouseEvent e, MouseEventType type) {
        Pair<MouseEvent, MouseEventType> duo = new Pair<>(e,type);
        unprocessedEvents.add(duo);
    }
}

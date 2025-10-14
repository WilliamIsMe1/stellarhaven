package stellarhaven.view.scene;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import stellarhaven.model.SpaceStation;
import stellarhaven.util.Coord;
import stellarhaven.util.MouseEventType;
import stellarhaven.util.Pair;
import stellarhaven.view.resources.assets.Background;
import stellarhaven.view.resources.assets.MoonBackground;

public class WorldScene extends Scene {

    private Coord offset = new Coord(0, 0);

    public Coord getOffset() {
        return offset;
    }

    private Coord lastMouseCoord = new Coord(0, 0);

    private final Background background = new MoonBackground();

    private HashMap<String,Double> numericalProperties = new HashMap<>();

    private HashMap<String,String> properties = new HashMap<>();

    private SpaceStation station = new SpaceStation();

    @Override
    public void draw(Graphics2D g2) {
        // First, draw the background as a repeating tile image that looks like the surface of the moon in isometric

        background.draw(g2, offset);
        station.draw(g2, offset);
    }

    @Override
    public void update() {
        while (!unprocessedEvents.isEmpty()) {
            Pair<MouseEvent,MouseEventType> pair = unprocessedEvents.remove(0);
            int lastX = lastMouseCoord.x;
            int lastY = lastMouseCoord.y;
            int deltaX = pair.getOne().getX() - lastX;
            int deltaY = pair.getOne().getY() - lastY;
            switch (pair.getTwo()) {
                case DRAG:
                    offset = offset.add(new Coord(deltaX, deltaY));
                case MOVE:
                    lastMouseCoord = new Coord(pair.getOne().getX(), pair.getOne().getY());
                    break;
                case CLICK:
                    handleClickEvent(pair.getOne().getX(), pair.getOne().getY());
                    break;
                default:
                    System.err.println("Whatever did you do to get here?");
                    System.exit(-1);
            }
        }
        station.update();
    }

    private void handleClickEvent(int x, int y) {
        
    }

    @Override
    public void initialize(HashMap<String, String> properties, HashMap<String, Double> numericalProperties) {
        this.properties = properties;
        this.numericalProperties = numericalProperties;
    }

    @Override
    public void initialize(HashMap<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String getProperty(String key) {
        return properties.getOrDefault(key,"");
    }

    @Override
    public double getNumericalProperty(String key) {
        return numericalProperties.getOrDefault(key,Double.NaN);
    }


}

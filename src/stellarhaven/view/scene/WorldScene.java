package stellarhaven.view.scene;

import java.awt.Graphics2D;
import java.util.HashMap;

import stellarhaven.model.SpaceStation;

public class WorldScene extends Scene {

    private int offsetX = 0, offsetY = 0;

    private HashMap<String,Double> numericalProperties = new HashMap<>();
    
    private HashMap<String,String> properties = new HashMap<>();

    private SpaceStation station = new SpaceStation();

    @Override
    public void draw(Graphics2D g2) {
        station.draw(g2, offsetX, offsetY);
    }

    @Override
    public void update() {
        
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

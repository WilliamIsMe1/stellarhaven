package stellarhaven.view.scene;

import java.awt.Graphics2D;
import java.util.HashMap;

public class WorldScene extends Scene {

    private HashMap<String,Double> numProperties = new HashMap<>();
    
    private HashMap<String,String> properties = new HashMap<>();

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void initialize(HashMap<String, String> properties, HashMap<String, Double> numericalProperties) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void initialize(HashMap<String, String> properties) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public String getProperty(String key) {
        return properties.getOrDefault(key,"");
    }

    @Override
    public double getNumericalProperty(String key) {
        return numProperties.getOrDefault(key,Double.NaN);
    }
    
}

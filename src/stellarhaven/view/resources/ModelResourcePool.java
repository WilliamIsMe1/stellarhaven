package stellarhaven.view.resources;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import stellarhaven.view.resources.assets.Model;

public class ModelResourcePool extends ResourcePool<Model> {
    private final HashMap<String, Model> models = new HashMap<>();

    @Override
    public Model getItem(String path) {
        if (models.containsKey(path)) {
            return models.get(path);
        }
        try (ObjectInputStream ois = new ObjectInputStream(getClass().getResourceAsStream(path))) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}

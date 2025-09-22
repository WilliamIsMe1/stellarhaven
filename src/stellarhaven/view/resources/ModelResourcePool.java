package stellarhaven.view.resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

import stellarhaven.view.resources.assets.Model;

/**
 * This class creates and retrieves {@link Model} objects in a massive pool.
 */
public class ModelResourcePool extends ResourcePool<Model> {
    private final HashMap<String, Model> models = new HashMap<>();

    @Override
    public Model getItem(String path) {
        if (!models.containsKey(path)) {
            try (InputStreamReader re = new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(path)))) {
            JsonElement parser = JsonParser.parseReader(re);
                // TODO: DO THIS

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("It appears that " + path + " does not exist");
            }
        }
        return models.get(path);
    }
}

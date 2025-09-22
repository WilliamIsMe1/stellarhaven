package stellarhaven.view.resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

import stellarhaven.util.Constants;
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
                // Eughh, some whitespace, please.
                JsonElement parsed = JsonParser.parseReader(re);
                JsonObject obj = parsed.getAsJsonObject();
                String type = obj.get("type").getAsString();
                if (type.equals("block")) {

                } else if (type.equals("static")) {
                    String path1 = obj.get("texture").getAsString();
                    BufferedImage img1 = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(path1);
                    Model m1 = new Model(img1);
                    models.put(path, m1);
                } else {
                    throw new ClassCastException("You have bad file or code");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.err.println("It appears that " + path + " does not exist");
                return null;
            } catch (ClassCastException e) {
                System.err.println("It appears that either " + path + " is not formatted correctly or you have a bug in the parsing code.");
                return null.
            }
        }
        return models.get(path);
    }
}

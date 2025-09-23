package stellarhaven.view.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import stellarhaven.util.Constants;
import stellarhaven.view.resources.assets.Model;
import stellarhaven.view.resources.assets.ForegroundObject;

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
                    String path2 = obj.get("background").getAsString(); // background
                    String path3 = obj.get("foreground").getAsString(); // foreground
                    JsonArray objList = obj.get("objects").getAsJsonArray(); // objects
                    ArrayList<ForegroundObject> foregroundObjects = new ArrayList<>();
                    for (JsonElement jE : objList) {
                        JsonObject obj2 = jE.getAsJsonObject();
                        String path4 = obj2.get("texture").getAsString();
                        int x1 = obj2.get("x").getAsInt();
                        int y1 = obj2.get("y").getAsInt();
                        BufferedImage img2 = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(path4);
                        ForegroundObject foregroundObject = new ForegroundObject(img2, x1, y1);
                        foregroundObjects.add(foregroundObject);
                    }
                    BufferedImage img3 = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(path2); // Background
                    BufferedImage img4 = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(path3); // Foreground
                    Model m2 = new Model(img4, img3, foregroundObjects);
                    models.put(path, m2);
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

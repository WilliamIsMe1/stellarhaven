package stellarhaven.view.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import stellarhaven.util.Constants;
import stellarhaven.view.resources.assets.Model;
import stellarhaven.view.resources.assets.ForegroundObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class creates and retrieves {@link Model} objects in a massive pool.
 */
public class ModelResourcePool extends ResourcePool<Model> {
    private final HashMap<String, Model> models = new HashMap<>();

    @Override
    public Model getItem(String path) {
        if (models.containsKey(path)) return models.get(path);

        JsonObject modelJson = loadJson(path);
        if (modelJson == null) return null;

        try {
            Model model = createModelFromJson(modelJson);
            models.put(path, model);
            return model;
        } catch (Exception e) {
            System.err.println("Failed to create model from " + path + ": " + e.getMessage());
            return null;
        }
    }

    private JsonObject loadJson(String path) {
        try (InputStreamReader reader = new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)))) {
            JsonElement parsed = JsonParser.parseReader(reader);
            return parsed.getAsJsonObject();
        } catch (IOException e) {
            System.err.println("Problems loading model: " + path);
        } catch (NullPointerException e) {
            System.err.println("Resource does not exist: " + path);
        }
        return null;
    }

    private Model createModelFromJson(JsonObject modelJson) {
        String type = modelJson.get("type").getAsString();

        return switch (type) {
            case "static" -> createStaticModel(modelJson);
            case "block" -> createBlockModel(modelJson);
            default -> throw new IllegalArgumentException("Unknown model type: " + type);
        };
    }

    private Model createStaticModel(JsonObject json) {
        String texturePath = json.get("texture").getAsString();
        BufferedImage texture = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(texturePath);
        return new Model(texture);
    }

    private Model createBlockModel(JsonObject json) {
        String backgroundPath = json.get("background").getAsString();
        String foregroundPath = json.get("foreground").getAsString();
        JsonArray objectsArray = json.get("objects").getAsJsonArray();

        ArrayList<ForegroundObject> foregroundObjects = new ArrayList<>();
        for (JsonElement element : objectsArray) {
            JsonObject obj = element.getAsJsonObject();
            String texturePath = obj.get("texture").getAsString();
            int x = obj.get("x").getAsInt();
            int y = obj.get("y").getAsInt();

            BufferedImage texture = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(texturePath);
            foregroundObjects.add(new ForegroundObject(texture, x, y));
        }

        BufferedImage background = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(backgroundPath);
        BufferedImage foreground = (BufferedImage) ResourcePool.getPool(Constants.IMAGE_POOL).getItem(foregroundPath);

        return new Model(foreground, background, foregroundObjects);
    }
}

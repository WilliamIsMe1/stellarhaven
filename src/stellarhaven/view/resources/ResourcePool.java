package stellarhaven.view.resources;

import java.util.HashMap;

/**
 * A generic resource pool for loading and caching resources such as images, sounds, etc.
 * Each specific type of resource pool should extend this class and implement the getItem method.
 * 
 * Usage:
 * 1. Create a subclass of ResourcePool for the specific resource type (e.g., ImageResourcePool).
 * 2. Implement the getItem method to load and cache resources.
 * 3. Use createResourcePool to register the pool and obtain an ID for it.
 * 4. Retrieve the pool using getPool with the ID when needed.
 * 
 * @param <T> The type of resource being managed by the pool.
 * @author William
 */
public abstract class ResourcePool<T> { // My class

    private static final HashMap<Integer, ResourcePool<?>> pools = new HashMap<>();

    private static int counter = 0;

    /**
     * Registers a new {@link ResourcePool} and returns its unique ID.
     * @param newPool The {@link ResourcePool} to register
     * @return The unique ID associated with the registered pool
     */
    public static int createResourcePool(ResourcePool<?> newPool) {
        pools.put(counter, newPool);
        return counter++;
    }

    /**
     * Retrieves a registered {@link ResourcePool} by its ID.
     * @param id The ID of the desired {@link ResourcePool}
     * @return The {@link ResourcePool} associated with the given ID, or `null` if not found
     */
    public ResourcePool<?> getPool(int id) {
        if (!pools.containsKey(id)) throw new ArrayIndexOutOfBoundsException("No resource pool carries this ID at this moment: " + id);
        return pools.get(id);
    }

    /**This method should be implemented by subclasses to load and cache resources,
     * returning null if not found
     * @param path The path to the resource to be obtained
     * @return The resource
     */
    public abstract T getItem(String path);

}

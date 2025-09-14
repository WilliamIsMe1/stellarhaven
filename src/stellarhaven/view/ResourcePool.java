package stellarhaven.view;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * We are putting this comment in as a change
 */
public abstract class ResourcePool {
    private static HashMap<Integer, ResourcePool> pools = new HashMap<>();

    private static int counter = 0;

    public static int createResourcePool(Class<? extends ResourcePool> poolClass) {
        ResourcePool newPool;
        try {
            Constructor<? extends ResourcePool> constr = poolClass.getConstructor();
            newPool = (ResourcePool) constr.newInstance();

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        pools.put(counter, newPool);
        return counter++;
    }

    public ResourcePool getPool(int id) {
        return pools.get(id);
    }
}

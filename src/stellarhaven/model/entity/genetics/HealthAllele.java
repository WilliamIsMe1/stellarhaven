package stellarhaven.model.entity.genetics;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;

/**
 * This is the allele for health, for the {@link Genetics} class.
 * 
 * Strength goes from 1 to 10, 5 average.
 * 
 * @author William
 */
public class HealthAllele extends Allele<Integer> {
    /**
     * This is the table that carries the dominance values for instances
     * of {@link HealthAllele}.
     */
    private final HashMap<Integer,Integer> table = new HashMap<>();

    public HealthAllele(Integer value) {
        super(value);
        initializeTable();
        if (!table.containsKey(value)) {
            throw new IllegalArgumentException("I'm afraid that the health value of: " + value + " is illegal.");
        }
        this.dominanceScore = table.get(value);
    }

    private void initializeTable() {
        // le.put(health,dominance)
        table.put(1, 1);
        table.put(2, 2);
        table.put(3, 3);
        table.put(4, 4);
        table.put(5, 5);
        table.put(6, 4);
        table.put(7, 4);
        table.put(8, 2);
        table.put(9, 1);
        table.put(10, 1);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void mutate() {
        boolean upOrDown = new Random().nextBoolean();
        if (value >= 2 && value <= 9) {
            value += upOrDown ? 1 : -1;
        }
        else if (value == 1) {
            if (upOrDown)
                value++;
        } else if (value == 10) {
            if (!upOrDown)
                value--;
        } else {
            throw new IllegalStateException("HealthAllele instances are not supposed to be above 10 or below 1");
        }
    }
    
    public static Supplier<Allele<Integer>> getSupplier() { // This returns 5 on average
        return () -> {
            int health = (((int) (Math.random()*10) + 1) + ((int) (Math.random()*10) + 1) + ((int) (Math.random()*10) + 1)) / 3;
            return new HealthAllele(health);
        };
    }
}
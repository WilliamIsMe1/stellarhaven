package stellarhaven.model.entity.genetics;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * This is the allele for optimism, for the {@link Genetics} class.
 *
 * Optimism goes from -3 to 3, 0.5 average.
 *
 * @author William
 */
public class OptimismAllele extends Allele<Integer> {
    /**
     * This is the table that carries the dominance values for instances
     * of {@link OptimismAllele}.
     */
    private final HashMap<Integer,Integer> table = new HashMap<>();

    public OptimismAllele(Integer value) {
        super(value);
        initializeTable();
        if (!table.containsKey(value)) {
            throw new IllegalArgumentException("I'm afraid that the optimism value of: " + value + " is illegal.");
        }
        this.dominanceScore = table.get(value);
    }

    private void initializeTable() {
        // le.put(optimism,dominance)
        table.put(-3, 1);
        table.put(-2, 1);
        table.put(-1, 2);
        table.put(0,  3);
        table.put(1,  3);
        table.put(2,  2);
        table.put(3,  1);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void mutate() {
        boolean upOrDown = new Random().nextBoolean();
        if (value >= -2 && value <= 2) {
            value += upOrDown ? 1 : -1;
        }
        else if (value == -3) {
            if (upOrDown)
                value++;
        } else if (value == 3) {
            if (!upOrDown)
                value--;
        } else {
            throw new IllegalStateException("OptimismAllele instances are not supposed to be above 3 or below -3");
        }
    }

    public static Supplier<Allele<Integer>> getSupplier() { // This returns 0.5 on average
        return () -> { // Do 3d6 / 3 - 3
            int optimism = (int)Math.round((IntStream.of((int)(Math.random()*7+1),(int)(Math.random()*7+1),(int)(Math.random()*7+1),(int)(Math.random()*7+1))
                    .sorted().skip(1).sum() / 3.0) - 4);
            return new OptimismAllele(optimism);
        };
    }

}
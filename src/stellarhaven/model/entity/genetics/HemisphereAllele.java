package stellarhaven.model.entity.genetics;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class HemisphereAllele extends Allele<Double> {

    private static final HashMap<Integer, Integer> table = new HashMap<>();

    static {
        initializeTable();
    }

    /**
     * Constructs an allele with the given value.
     *
     * @param value The value to be carried by the allele
     */
    public HemisphereAllele(Double value) {
        super((double) Math.round(value*10));
    }

    private static void initializeTable() {
        table.put(0, 0);
        table.put(2, 0);
        table.put(4, 0);
        table.put(5, 0);
        table.put(6, 0);
        table.put(8, 0);
        table.put(10, 0);
    }

    /**
     * Gets the value carried by the allele.
     *
     * @return The value carried by the allele.
     */
    @Override
    public Double getValue() {
        return value / 10.0;
    }

    /**
     *
     */
    @Override
    public void mutate() {
        if (table.isEmpty()) {
            initializeTable();
        }

        // Get sorted keys
        var keys = table.keySet().stream().sorted().toList();

        // Find current index
        int currentIndex = keys.indexOf(value.intValue());
        if (currentIndex == -1) return; // current value not in table, skip mutation

        // Determine possible adjacent indices
        int lower = currentIndex > 0 ? currentIndex - 1 : currentIndex;
        int upper = currentIndex < keys.size() - 1 ? currentIndex + 1 : currentIndex;

        // Randomly pick one of the adjacent values
        int newIndex;
        if (lower == upper) {
            newIndex = currentIndex; // only one possible value
        } else {
            newIndex = Math.random() < 0.5 ? lower : upper;
        }

        // Update value
        value = (double) keys.get(newIndex);
    }

    public static Supplier<Allele<Double>> getSupplier() {
        return () -> {
            Set<Integer> keys = table.keySet();
            List<Integer> a = keys.stream().sorted().toList();
            int index = (int) (Math.random() * a.toArray().length);
            return new HemisphereAllele(a.get(index) / 10.0);
        };
    }
}

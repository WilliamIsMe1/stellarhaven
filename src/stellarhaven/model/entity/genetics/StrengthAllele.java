package stellarhaven.model.entity.genetics;

import java.util.HashMap;

/**
 * This is the allele for strength, for the {@link Genetics} class.
 * 
 * Strength goes from 1 to 10, 5 average.
 * 
 * @author William
 */
public class StrengthAllele extends Allele<Integer> {
    /**
     * This is the table that carries the dominance values for instances
     * of {@link StrengthAllele}.
     */
    private final HashMap<Integer,Integer> table = new HashMap<>();

    public StrengthAllele(Integer value) {
        super(value);
        initializeTable();
        if (!table.containsKey(value)) {
            throw new IllegalArgumentException("I'm afraid that the strength value of: " + value + " is illegal.");
        }
        this.dominanceScore = table.get(value);
    }

    private void initializeTable() {
        // le.put(strength,dominance)
        table.put(1, 1);
        table.put(2, 2);
        table.put(3, 3);
        table.put(4, 6);
        table.put(5, 10);
        table.put(6, 9);
        table.put(7, 8);
        table.put(8, 7);
        table.put(9, 5);
        table.put(10, 4);
    }

    @Override
    public Integer getValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public void mutate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mutate'");
    }
    
}
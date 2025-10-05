package stellarhaven.model.entity.genetics;

import java.util.Random;
import java.util.function.Supplier;

/**
 * An allele class for hair color, with its own enum type
 * 
 * @author William
 */
public class HairColorAllele extends Allele<HairColorAllele.Color> {
    
    /**
     * An enum created for the sole purpose of storing hair colors along with their dominance scores
     * 
     * @author William
     */
    public enum Color {
        BLACK(3, new java.awt.Color(15, 15, 10)),
        BROWN(2, new java.awt.Color(92, 64, 51)),
        BLONDE(1, new java.awt.Color(213, 192, 127)),
        RED(0, new java.awt.Color(149, 60, 48));
        public final int dominanceScore;
        public final java.awt.Color color;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }

    public HairColorAllele(Color c) {
        super(c);
        this.dominanceScore = c.dominanceScore;
    }

    public HairColorAllele() {
        this(Color.values()[(int)(Math.random() * Color.values().length)]);
    }

    @Override
    public Color getValue() {
        return value;
    }

    @Override
    public void mutate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mutate'");
    }

    public static Supplier<Allele<HairColorAllele.Color>> getSupplier() {
        return () -> {
            Color[] values = Color.values();
            return new HairColorAllele(values[new Random().nextInt()]);
        };
    }
}

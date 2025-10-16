package stellarhaven.model.entity.genetics;

import java.util.Random;
import java.util.function.Supplier;

/**
 * An allele class for eye color, with an accompaning enum
 * 
 * @author William
 */
public class EyeColorAllele extends Allele<EyeColorAllele.Color> {
    
    /**
     * An enum created for the sole purpose of storing hair colors along with their dominance scores
     * 
     * @author William
     */
    public enum Color {
        BROWN(3, new java.awt.Color(99,57,15)),
        GREEN(2, new java.awt.Color(61,103,29)),
        BLUE(1, new java.awt.Color(46,83,111));
        public final int dominanceScore;
        public final java.awt.Color color;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }
    
    /**
     * Explicit constructor
     * 
     * @param c Eye color of choice
     */
    public EyeColorAllele(Color c) {
        super(c);
        this.dominanceScore = c.dominanceScore;
    }

    /**
     * Random eye color allele
     */
    public EyeColorAllele() {
        this(Color.values()[(int)(Math.random() * Color.values().length)]);
    }

    @Override
    public void mutate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mutate'");
    }

    public static Supplier<Allele<EyeColorAllele.Color>> getSupplier() {
        return () -> {
            Color[] values = Color.values();
            return new EyeColorAllele(values[new Random().nextInt()]);
        };
    }
}
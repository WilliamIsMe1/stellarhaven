package stellarhaven.model.entity.genetics;

import java.util.Random;
import java.util.function.Supplier;

public class ColorPreferenceAllele extends Allele<ColorPreferenceAllele.Color> {

    public ColorPreferenceAllele(Color value) {
        super(value);
    }

    @Override
    public Color getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mutate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public enum Color {
        RED(5, java.awt.Color.decode("#F60000")),
        ORANGE(5, java.awt.Color.decode("#FF8C00")),
        YELLOW(5, java.awt.Color.decode("#FFEE00")),
        GREEN(5, java.awt.Color.decode("#00F600")),
        BLUE(5, java.awt.Color.decode("#3783FF")),
        PURPLE(5, java.awt.Color.decode("#4815AA")),
        GRAY(5, java.awt.Color.decode("#7F7F7F")),
        BLACK(5, java.awt.Color.decode("#0F0F0F")),
        WHITE(5, java.awt.Color.decode("#BFBFBF")),
        BROWN(5, java.awt.Color.decode("#825911"))
        ;
        public final java.awt.Color color;
        public final int dominanceScore;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }

    public static Supplier<Allele<ColorPreferenceAllele.Color>> getSupplier() {
        return () -> {
            Color[] values = Color.values();
            return new ColorPreferenceAllele(values[new Random().nextInt()]);
        };
    }
}

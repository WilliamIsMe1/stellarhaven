package stellarhaven.model.entity.genetics;

public class EyeColorAllele extends Allele<EyeColorAllele.Color> {
    public enum Color {
        BLUE(3, new java.awt.Color(0,0,255));
        public final int dominanceScore;
        public final java.awt.Color color;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }
    }

    public EyeColorAllele(Color c) {
        super(c);
        this.dominanceScore = c.dominanceScore;
    }
}
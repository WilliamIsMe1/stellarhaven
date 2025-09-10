package stellarhaven.entity.genetics;

public class HairColorAllele extends Allele {
    public enum Color {
        BLACK(3, new java.awt.Color( 15, 15, 10)),
        BROWN(2, new java.awt.Color( 92, 64, 51)),
        BLONDE(1, new java.awt.Color(213, 192, 127)),
        RED(0, new java.awt.Color(149, 60, 48));
        public final int dominanceScore;
        public final java.awt.Color color;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }
    private final Color c;
    public HairColorAllele(Color c) {
        this.c = c;
        this.dominanceScore = c.dominanceScore;
    }
}

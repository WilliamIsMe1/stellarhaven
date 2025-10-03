package stellarhaven.model.entity.genetics;


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
        RED(5, new java.awt.Color(255,0,0)),
        ORANGE(5, new java.awt.Color(255,125,0))
        ;
        public final java.awt.Color color;
        public final int dominanceScore;
        Color(int dominanceScore, java.awt.Color correspondingColor) {
            this.dominanceScore = dominanceScore;
            this.color = correspondingColor;
        }
    }

    
}

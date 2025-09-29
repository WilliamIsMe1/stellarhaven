package stellarhaven.model.entity;

import java.awt.Graphics2D;

import stellarhaven.model.entity.genetics.Gender;
import stellarhaven.model.entity.genetics.Genetics;
import stellarhaven.util.Coord;

public final class EntityPerson extends Entity {
    public EntityPerson(Coord location, Coord subLocation) {
        super(location, subLocation);
        this.genetics = null;
    }

    @SuppressWarnings("FieldMayBeFinal")
    private Genetics genetics;

    public Gender getGender() {
        return genetics.getGender();
    }

    @Override
    public void draw(Graphics2D g2, Coord offset) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

}


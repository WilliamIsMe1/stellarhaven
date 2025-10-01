package stellarhaven.model.entity;

import java.awt.Graphics2D;
import java.util.Objects;

import stellarhaven.model.entity.genetics.Gender;
import stellarhaven.model.entity.genetics.Genetics;
import stellarhaven.util.Coord;

public final class EntityPerson extends Entity {

    public EntityPerson(Coord location, Coord subLocation) {
        this("Gary", location, subLocation);
    }

    public EntityPerson(String name, Coord location, Coord subLocation) {
        super(location, subLocation);
        this.genetics = null;
        this.name = name;
    }

    @SuppressWarnings("FieldMayBeFinal")
    private Genetics genetics;

    private String name;

    public Gender getGender() {
        return genetics.getGender();
    }

    public String getName() {
        return Objects.toString(name, "Gary");
    }

    @Override
    public void draw(Graphics2D g2, Coord offset) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

}


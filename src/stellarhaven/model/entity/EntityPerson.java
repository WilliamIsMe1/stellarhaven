package stellarhaven.model.entity;

import stellarhaven.Coord;
import stellarhaven.entity.genetics.Genetics;

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

}


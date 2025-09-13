package stellarhaven.model.entity;

import stellarhaven.model.Coord;
import stellarhaven.model.entity.genetics.Gender;
import stellarhaven.model.entity.genetics.Genetics;

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


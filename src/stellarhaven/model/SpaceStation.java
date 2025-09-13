package stellarhaven.model;
import stellarhaven.model.entity.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SpaceStation implements Serializable {
    private static final long serialVersionUID = -1L;

    HashMap<Coord, Structure> world = new HashMap<>();
    HashMap<Structure, ArrayList<Entity>> entities = new HashMap<>();


}

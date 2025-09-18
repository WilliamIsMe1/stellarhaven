package stellarhaven.model;

import java.util.ArrayList;
import stellarhaven.model.entity.Entity;
import stellarhaven.view.resources.assets.Model;

public abstract class Structure {
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected boolean habitable = true;
    protected Model texture;
}

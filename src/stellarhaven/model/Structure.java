package stellarhaven.model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import stellarhaven.model.entity.Entity;
import stellarhaven.util.Coord;
import stellarhaven.view.resources.assets.Model;

public abstract class Structure {
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected boolean habitable = true;
    protected Model texture;

    public void draw(Graphics2D g2, Coord parentCoord) {
        texture.draw(g2, entities, false, parentCoord);
    }

    public abstract void update();
}

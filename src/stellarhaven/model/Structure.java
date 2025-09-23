package stellarhaven.model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import stellarhaven.model.entity.Entity;
import stellarhaven.util.Coord;
import stellarhaven.util.CoordTransform;
import stellarhaven.view.resources.assets.Model;

public abstract class Structure {
    protected ArrayList<Entity> entities = new ArrayList<>();
    protected boolean habitable = true;
    protected Model texture;
    protected int zIndex;

    public int getZIndex() {
        return zIndex;
    }

    public void setZIndex(int z) {
        zIndex = z;
    }

    public void draw(Graphics2D g2, CoordTransform passedInTransform, Coord parentCoord) {

    }
}

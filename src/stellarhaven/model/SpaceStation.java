package stellarhaven.model;
import stellarhaven.model.entity.Entity;
import stellarhaven.util.Coord;
import stellarhaven.util.IsometricUtils;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SpaceStation implements Serializable {
    private static final long serialVersionUID = -1L;

    HashMap<Coord, Structure> world = new HashMap<>();
    HashMap<Structure, ArrayList<Entity>> entities = new HashMap<>();
    public void draw(Graphics2D g2, Coord offset) {
        // First all structures must be Z sorted by coordinate. A Comparator<Map.Entry<Coord,Structure>> should do.
        
    }


}

package stellarhaven.model;
import stellarhaven.model.entity.Entity;
import stellarhaven.util.Coord;
import stellarhaven.util.IsometricUtils;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpaceStation implements Serializable {
    private static final long serialVersionUID = -1L;

    HashMap<Coord, Structure> world = new HashMap<>();
    HashMap<Structure, ArrayList<Entity>> entities = new HashMap<>();
    public void draw(Graphics2D g2, int offsetX, int offsetY) {
        ArrayList<Structure> zIndexCoords = new ArrayList<>();
        for (Map.Entry<Coord, Structure> tile : world.entrySet()) {
            Coord currentCoord = tile.getKey();
            Structure currentStructure = tile.getValue();
            Coord screenCoord = IsometricUtils;
            // TODO: finish draw code
        }
    }


}

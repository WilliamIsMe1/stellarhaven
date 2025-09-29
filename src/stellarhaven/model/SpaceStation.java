package stellarhaven.model;
import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
import stellarhaven.util.IsometricUtils;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpaceStation implements Serializable {
    private static final long serialVersionUID = -1L;

    private transient boolean updatedSinceLastTick = true; // Have tiles been added or deleted?

    HashMap<Coord, Structure> world = new HashMap<>();

    private transient ArrayList<Map.Entry<Coord,Structure>> sortedWorld;

    public void draw(Graphics2D g2, Coord offset) {
        // First all structures must be Z sorted by coordinate. A Comparator<Map.Entry<Coord,Structure>> should do.
        if (updatedSinceLastTick) {
            sortedWorld = new ArrayList<>(world.entrySet());
            sortedWorld.sort((a, b) -> {
                Coord isometricA = IsometricUtils.calculateIsometric(a.getKey());
                Coord isometricB = IsometricUtils.calculateIsometric(b.getKey());
                
                return Integer.compare(isometricA.y, isometricB.y);
            }); // Now that it's sorted, we need to draw it.
        }

        for (Map.Entry<Coord, Structure> e : sortedWorld) {
            e.getValue().draw(
                g2, 
                IsometricUtils.calculateIsometric(e.getKey())
                    .multiply(Constants.TILE_SIZE/2)
                    .add(offset)
            ); // Draw it where it is. We can do culling later.
        }

    }


}

package stellarhaven.model.entity;

import stellarhaven.util.Coord;

/**
 * A base class for all entities in the game
 * world, containing their location in Tiles
 * and where they are in that tile
 * 
 * @author William
 */
public abstract class Entity {

    /**
     * Location of entity in tiles
     */
    protected Coord location;
    /**
     * Location of entity within its tile
     */
    protected Coord subLocation; // Where are they in their individual tile

    /**
     * Creates a new Entity at the given location
     * and sub-location
     * 
     * @param location The tile location of the entity
     * @param subLocation The sub-location of the entity within its tile
     */
    public Entity(Coord location, Coord subLocation) {
        this.location = location;
        this.subLocation = subLocation;
    }
}

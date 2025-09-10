package stellarhaven.entity;

import stellarhaven.Coord;

public abstract class Entity {
    protected Coord location;
    protected Coord subLocation; // Where are they in their individual tile

    public Entity(Coord location, Coord subLocation) {
        this.location = location;
        this.subLocation = subLocation;
    }
}

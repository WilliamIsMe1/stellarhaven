package stellarhaven.util;

@FunctionalInterface
public interface CoordTransform {
    public Coord transform(Coord coord);
}

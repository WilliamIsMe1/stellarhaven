package stellarhaven.util;

/**
 * @author William
 * @param x x coordinate
 * @param y y coordinate
 */
public class Coord {
    public final int x, y;

    /**
     * Creates a new coordinate with the given x and y values
     * @param x The X value (using cartesian coordinates)
     * @param y The Y value (using cartesian coordinates)
     */
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copies another instance of {@link Coord}
     * @param other The other {@link Coord} object
     */
    public Coord(Coord other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Coord)) return false;
        Coord o = (Coord) other;
        return (o.x == x) && (o.y == y);
    }

    public Coord add(Coord other) {
        return new Coord(other.x + x, other.y + y);
    }

    public Coord multiply(int other) {
        return new Coord(x*other,y*other);
    }

    @Override
    public String toString() {
        return "Coord[" + x + ", " + y + "]";
    }
}

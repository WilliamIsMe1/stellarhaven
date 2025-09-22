package stellarhaven.util;

public class IsometricUtils implements Constants {
    private IsometricUtils() {}

    public static Coord calculateIsometric(Coord c) {
        return new Coord((c.x - c.y) / 2 , (c.x + c.y) / 4);
    }

    public static Coord calculateIsometric(int x, int y) {
        return calculateIsometric(new Coord(x, y));
    }

    public static Coord fromIsometric(Coord c) {
        int originalX = c.x + 2 * c.y;
        int originalY = 2 * c.y - c.x;
        return new Coord(originalX, originalY);
    }


    public static Coord fromIsometric(int x, int y) {
        return fromIsometric(new Coord(x, y));
    }
}

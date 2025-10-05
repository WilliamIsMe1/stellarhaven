package stellarhaven.util;

public class IsometricUtils implements Constants {
    private IsometricUtils() {}

    public static Coord calculateIsometric(Coord c) {
        return new Coord((int) ((c.x - c.y) / 2.0 ), (int) ((c.x + c.y) / 4.0));
    }

    public static Coord calculateIsometric(int x, int y) {
        return calculateIsometric(new Coord(x, y));
    }

}

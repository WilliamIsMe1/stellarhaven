package stellarhaven.util;

public class IsometricUtils implements Constants {
    private IsometricUtils() {}

    public static Coord calculateIsometric(Coord c) {
        return new Coord((c.x - c.y) * TILE_X_SIZE / 2 + TILE_X_SIZE/2, (c.x + c.y) * TILE_Y_SIZE / 4 + TILE_X_SIZE/2); // Transform, multiply by tile size divided by 2, then center.
    }

    public static Coord calculateIsometric(int x, int y) {
        return calculateIsometric(new Coord(x, y));
    }

    public Coord fromIsometric(Coord c) {
        return new Coord((int) (c.x / TILE_X_SIZE + 2 * c.y / TILE_Y_SIZE - 0.5 - TILE_X_SIZE / TILE_Y_SIZE), (int) (-c.x / TILE_X_SIZE + 2 * c.y / TILE_Y_SIZE + 0.5 - TILE_X_SIZE / TILE_Y_SIZE));
    }

    public Coord fromIsometric(int x, int y) {
        return fromIsometric(new Coord(x, y));
    }
}

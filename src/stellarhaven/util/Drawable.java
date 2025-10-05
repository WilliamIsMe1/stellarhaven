package stellarhaven.util;

import java.awt.*;

public interface Drawable {
    void draw(Graphics2D g2, Coord parentCoord);
    int getX();
    int getY();
}

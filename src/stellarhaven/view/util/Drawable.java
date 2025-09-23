package stellarhaven.view.util;

import stellarhaven.util.Coord;

import java.awt.Graphics2D;

public interface Drawable {
    public void draw(Graphics2D g2, Coord offset);
}

package stellarhaven.model.entity;

import java.awt.Graphics2D;
import java.util.Objects;
import stellarhaven.model.entity.genetics.Gender;
import stellarhaven.model.entity.genetics.Genetics;
import stellarhaven.util.Constants;
import stellarhaven.util.Coord;
import stellarhaven.util.IsometricUtils;
import stellarhaven.view.scene.WorldScene;

public final class EntityPerson extends Entity {

    public EntityPerson(Coord location, Coord subLocation) {
        this("Gary", location, subLocation);
    }

    public EntityPerson(String name, Coord location, Coord subLocation) {
        super(location, subLocation);
        this.genetics = null;
        this.name = name;
    }

    @SuppressWarnings("FieldMayBeFinal")
    private Genetics genetics;

    private final String name;

    public Gender getGender() {
        return genetics.getGender();
    }

    public String getName() {
        return Objects.toString(name, "Gary");
    }

    @Override
    public void draw(Graphics2D g2, Coord offset) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    private Coord fetchOffset() {
        return ((WorldScene) stellarhaven.Main.gp.getCurrentScene()).getOffset(); // I hate these messy solutions
        // TODO: FIX THIS CRAP
    }

    @Override
    public int getX() {
        return IsometricUtils.calculateIsometric(location.multiply(Constants.TILE_SIZE))
                .multiply(Constants.GAME_SCALE)
                .add(fetchOffset())
                .add(IsometricUtils.calculateIsometric(subLocation)).x;
    }

    @Override
    public int getY() {
        return IsometricUtils.calculateIsometric(location.multiply(Constants.TILE_SIZE))
                        .multiply(Constants.GAME_SCALE)
                .add(fetchOffset())
                .add(IsometricUtils.calculateIsometric(subLocation)).y;
    }

}


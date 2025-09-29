package stellarhaven.model.entity.brain;

import java.util.ArrayList;

import stellarhaven.model.entity.Entity;

/**
 * This brain executes goals for {@link Entity} instances
 */
public class Brain {
    ArrayList<Goal> goals;
    Entity parent;
}

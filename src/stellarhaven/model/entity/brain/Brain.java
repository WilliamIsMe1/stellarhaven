package stellarhaven.model.entity.brain;

import java.util.ArrayList;

import stellarhaven.model.entity.Entity;
import stellarhaven.util.Coord;

/**
 * This brain executes goals for {@link Entity} instances
 */
public class Brain {
    ArrayList<Goal> goals;
    Entity host;
    /**
     * Skills are here. I'm not sure how to store them yet.
     * The kinds of skills that need to be stored are 
     * * Fine motor skills
     * * Computer skills
     * * Mechanical skills
     * * Gardening skills
     * Each structure requires a specific set of jobs, that each require certain skills
     */
    ArrayList<Coord> knownLocations = new ArrayList<>();
    ArrayList<Pair<EntityPerson,Integer>> friends = new ArrayList<>();
}

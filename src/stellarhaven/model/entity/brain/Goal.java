package stellarhaven.model.entity.brain;

import stellarhaven.model.entity.Entity;

/**
 * This class can be extended to MoveGoal, WorkGoal
 * 
 */
public abstract class Goal {
    /**
     * 
     * @param host This is the host that your life depends upon
     * @return Whether {@link Goal} is met
     */
    public abstract boolean pursue(Entity host);
}

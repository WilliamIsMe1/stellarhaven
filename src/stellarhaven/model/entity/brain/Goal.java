package stellarhaven.model.entity.brain;

import stellarhaven.model.entity.Entity;

import java.util.Comparator;

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

    /**
     *
     * @return What priority {@link Goal} is
     */
    public abstract int getPriority();

    public static class GoalComparator implements Comparator<Goal> {

        @Override
        public int compare(Goal o1, Goal o2) {
            return o1.getPriority() - o2.getPriority();
        }
    }
}

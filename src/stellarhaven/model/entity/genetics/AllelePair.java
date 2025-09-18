package stellarhaven.model.entity.genetics;


/**
 * An {@link AllelePair} represents a pair of {@link Allele} instances
 * and handles the fetching of dominant alleles automatically. 
 * 
 * @author William
 */
public class AllelePair<T> {
    final Allele<T> one;
    final Allele<T> two;

    public AllelePair(Allele<T> one, Allele<T> two) throws IllegalArgumentException {
        if (!one.getClass().equals(two.getClass())) {
            throw new IllegalArgumentException("Don't combine different allele types!");
        }
        this.one = one;
        this.two = two;
    }

    public Allele<T> getDominantAllele() {
        if (one.compareTo(two) > 0) {
            return one;
        }
        return two;
    }

    public static AllelePair inherit(AllelePair<?> parent1, AllelePair<?> parent2) {
        Allele<?> alleleFromParent1 = Math.random() < 0.5 ? parent1.one : parent1.two;
        Allele<?> alleleFromParent2 = Math.random() < 0.5 ? parent2.one : parent2.two;
        return new AllelePair(alleleFromParent1, alleleFromParent2);
    }

}

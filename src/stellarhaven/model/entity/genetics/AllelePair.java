package stellarhaven.model.entity.genetics;

import java.util.Random;
import java.util.function.Supplier;

/**
 * An {@link AllelePair} represents a pair of {@link Allele} instances
 * and handles the fetching of dominant alleles automatically. 
 * 
 * @author William
 */
public class AllelePair<T> {
    final Allele<T> one;
    final Allele<T> two;
    final boolean preference;

    public AllelePair(Allele<T> one, Allele<T> two) throws IllegalArgumentException {
        if (!one.getClass().equals(two.getClass())) {
            throw new IllegalArgumentException("Don't combine different allele types!");
        }
        this.one = one;
        this.two = two;
        preference = new Random().nextBoolean();
    }

    public Allele<T> getDominantAllele() {
        if (one.compareTo(two) > 0) {
            return one;
        } else if (one.compareTo(two) == 0) {
            return preference ? one : two;
        }
        return two;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static AllelePair<?> inherit(AllelePair<?> parent1, AllelePair<?> parent2) {
        Allele<?> alleleFromParent1 = Math.random() < 0.5 ? parent1.one : parent1.two;
        Allele<?> alleleFromParent2 = Math.random() < 0.5 ? parent2.one : parent2.two;
        return new AllelePair(alleleFromParent1, alleleFromParent2);
    }

    public AllelePair(Supplier<Allele<T>> supplier) {
        one = supplier.get();
        two = supplier.get();
        preference = new Random().nextBoolean();
    }
}

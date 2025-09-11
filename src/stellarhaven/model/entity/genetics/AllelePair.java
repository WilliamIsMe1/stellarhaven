package stellarhaven.model.entity.genetics;

public class AllelePair {
    final Allele one;
    final Allele two;

    public AllelePair(Allele one, Allele two) throws IllegalArgumentException {
        if (one.getClass() != two.getClass()) {
            throw new IllegalArgumentException("one.class != two.class");
        }
        this.one = one;
        this.two = two;
    }

    public Allele getDominantAllele() {
        if (one.compareTo(two) > 0) {
            return one;
        }
        return two;
    }

    public static AllelePair inherit(AllelePair parent1, AllelePair parent2) {
        Allele alleleFromParent1 = Math.random() < 0.5 ? parent1.one : parent1.two;
        Allele alleleFromParent2 = Math.random() < 0.5 ? parent2.one : parent2.two;
        return new AllelePair(alleleFromParent1, alleleFromParent2);
    }

}

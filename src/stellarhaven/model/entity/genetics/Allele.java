package stellarhaven.model.entity.genetics;

public class Allele implements Comparable<Allele> {
    protected int dominanceScore;
    @Override
    public int compareTo(Allele o) {
        return dominanceScore - o.dominanceScore;
    }
}

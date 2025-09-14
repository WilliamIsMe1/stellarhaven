package stellarhaven.model.entity.genetics;

/**
 * An allele is the controller of a gene. There are two alleles per {@link AllelePair}. Each 
 * allele has a {@link #dominanceScore}, which is used to determine which allele is dominant
 * 
 * @author William
 * @param T The type of value to be stored in the allele
 */
public class Allele<T> implements Comparable<Allele<?>> {

    /**
     * This is the dominance score of this allele. It is used as a criterion for
     * the {@link #compareTo(Allele)} method.
     */
    protected int dominanceScore;

    /**
     * This is the value carried by the allele.
     */
    protected T value;

    /**
     * Gets the value carried by the allele.
     * 
     * @return The value carried by the allele.
     */
    public T getValue() {
        return null;
    }

    /**
     * Constructs an allele with the given value.
     * 
     * @param value The value to be carried by the allele
     */
    public Allele(T value) {
        this.value = value;
    }

    /**
     * Compares two alleles based on the dominance score, allowing
     * sorting without having to do it myself. I love stealing code :)
     * @param o The other allele to compare to
     * @return A positive number if this allele is more dominant, negative if less, and zero if equal
     * @throws IllegalArgumentException if the alleles are of different types
     */
    @Override
    public int compareTo(Allele<?> o) {
        if (!o.getClass().equals(this.getClass())) { // If o's class is different to this class
            throw new IllegalArgumentException("Cannot compare alleles of different types."); // Then throw this exception
        }
        return dominanceScore - o.dominanceScore;
    }
}

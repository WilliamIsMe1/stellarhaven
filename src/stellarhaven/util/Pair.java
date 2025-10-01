package stellarhaven.util;

public final class Pair<K, V> {
    private final K one;
    private final V two;

    public Pair(K one, V two) {
        if (!hasOverriddenEqualsAndHashCode(one.getClass()) && !hasOverriddenEqualsAndHashCode(two.getClass())) {
            throw new IllegalArgumentException("Please override your .equals() and .hashCode()");
        }
        this.one = one;
        this.two = two;
    }

    public K getOne() {
        return one;
    }

    public V getTwo() {
        return two;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (pair.getOne().equals(this.getOne()) && pair.getTwo().equals(this.getTwo())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, two);
    }

    private boolean hasOverriddenEqualsAndHashCode(Class<?> clazz) {
        try {
            clazz.getDeclaredMethod("equals", Object.class);
            clazz.getDeclaredMethod("hashCode");
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}

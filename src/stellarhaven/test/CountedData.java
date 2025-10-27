package stellarhaven.test;

import stellarhaven.util.Equatable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountedData<T extends Equatable> {
    HashMap<T, Integer> currentDataCounted = new HashMap<>();

    public void add(T o) {
        if (currentDataCounted.containsKey(o)) {
            currentDataCounted.put(o, currentDataCounted.get(o) + 1);
        } else {
            currentDataCounted.put(o, 1);
        }
    }

    public int getCount(T o) {
        return currentDataCounted.get(o) == null ? 0 : currentDataCounted.get(o);
    }

    public String displaySideways() {
        StringBuilder sb = new StringBuilder();
        int highWidth = getCount(getHighest());
        for (T entry : currentDataCounted.keySet()) {
            sb.append(entry).append("[");
            sb.append("#".repeat(Math.max(0, getCount(entry))));
            sb.append(".".repeat(Math.max(0, highWidth - getCount(entry))));
            sb.append("] ").append(getCount(entry));
        }
        return sb.toString();
    }

    public T getHighest() {
        T highest = null;
        for (Map.Entry<T, Integer> entry : currentDataCounted.entrySet()) {
            if (entry.getValue() > currentDataCounted.getOrDefault(entry.getKey(), 0)) {
                highest = entry.getKey();
            } else if (Objects.equals(entry.getValue(), currentDataCounted.getOrDefault(entry.getKey(), 0))) {
                // Randomly choose to continue or not (may prioritize the endings; needs fixing)
            }
        }
        return highest;
    }

    public String toString() {
        return displaySideways();
    }

}

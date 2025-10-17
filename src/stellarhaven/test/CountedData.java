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

    public void displaySideways() {
        int highWidth = getCount(getHighest());
        for (T entry : currentDataCounted.keySet()) {
            System.out.print(entry + "[");
            for (int i = 0; i < getCount(entry); i++) {
                System.out.print("#");
            }
            for (int j = getCount(entry); j < highWidth; j++) {
                System.out.print(".");
            }
            System.out.println("] " + getCount(entry));
        }
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

}

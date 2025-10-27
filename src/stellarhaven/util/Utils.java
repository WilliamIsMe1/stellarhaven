package stellarhaven.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private Utils() {}

    // [low, high)
    public static Integer[] range(int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException();
        }
        if  (low == high) {
            return new Integer[]{low};
        }
        List<Integer> list = new ArrayList<>();
        for (int i=low; i<=high; i++) {
            list.add(i);
        }
        if (list.isEmpty()) { return null; }
        return (Integer[]) list.toArray();
    }

    // [0, high)
    public static Integer[] range(int high) {
        return range(0, high);
    }
}

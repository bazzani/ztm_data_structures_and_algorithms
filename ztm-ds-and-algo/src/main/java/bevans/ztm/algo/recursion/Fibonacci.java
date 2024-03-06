package bevans.ztm.algo.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {
    long iterations = 0;

    private final Map<Integer, Integer> cache = new HashMap<>();

    int fibonacciRecursive(int index) {
        iterations++;

        if (!cache.containsKey(index)) {
            if (index < 2) {
                cache.put(index, index);
            } else {
                cache.put(index, fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2));
            }
        }

        return cache.get(index);
    }

    int fibonacciIterative(int index) {
        var arr = new ArrayList<>(List.of(0, 1));

        for (int i = 2; i < index + 1; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }

        return arr.get(index);
    }
}

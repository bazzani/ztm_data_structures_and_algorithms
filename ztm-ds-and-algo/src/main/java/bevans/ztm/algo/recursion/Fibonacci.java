package bevans.ztm.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    int fibonacciRecursive(int index) {
        if (index < 2) {
            return index;
        }

        return fibonacciRecursive(index - 1) + fibonacciRecursive(index - 2);
    }

    int fibonacciIterative(int index) {
        var arr = new ArrayList<>(List.of(0, 1));

        for (int i = 2; i < index + 1; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }

        return arr.get(index);
    }
}

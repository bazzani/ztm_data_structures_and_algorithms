package bevans.ztm.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        var length = array.length;
        var middle = (int) Math.floor(length / 2);

        var left = Arrays.copyOfRange(array, 0, middle);
        var right = Arrays.copyOfRange(array, middle, array.length);

        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        var result = new ArrayList<Integer>(left.length + right.length);

        var leftIndex = 0;
        var rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result.add(left[leftIndex]);
                leftIndex++;
            } else {
                result.add(right[rightIndex]);
                rightIndex++;
            }
        }

        for (int restLeftIndex = leftIndex; restLeftIndex < left.length; restLeftIndex++) {
            result.add(left[restLeftIndex]);
        }
        for (int restRightIndex = rightIndex; restRightIndex < right.length; restRightIndex++) {
            result.add(right[restRightIndex]);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

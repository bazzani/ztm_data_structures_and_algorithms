package bevans.ztm.algo.sort;

import java.util.Arrays;

public class SelectionSort {
    static int SWAP_COUNT = 0;

    public void sort(int[] array) {
        var arrayLength = array.length;

        System.out.println("array = " + Arrays.toString(array));

        for (int i = 0; i < arrayLength; i++) {
            var smallest = array[i];
            var smallestIndex = i;

            for (int j = i; j < arrayLength; j++) {
                if (array[j] < smallest) {
                    smallest = array[j];
                    smallestIndex = j;
                    SWAP_COUNT++;
                }
            }

            var temp = array[i];
            array[i] = smallest;
            array[smallestIndex] = temp;

            System.out.println("array = " + Arrays.toString(array));
        }
    }
}

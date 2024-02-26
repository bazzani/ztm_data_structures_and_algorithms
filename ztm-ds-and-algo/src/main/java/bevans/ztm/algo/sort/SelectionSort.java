package bevans.ztm.algo.sort;

import java.util.Arrays;

public class SelectionSort {
    static int SWAP_COUNT = 0;

    public void sort(int[] array) {
        var arrayLength = array.length;

        System.out.println("array = " + Arrays.toString(array));

        for (int i = 0; i < arrayLength; i++) {
            var min = i;
            var temp = array[i];

            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[min]) {
                    min = j;
                    SWAP_COUNT++;
                }
            }

            array[i] = array[min];
            array[min] = temp;

            System.out.println("array = " + Arrays.toString(array));
        }
    }
}

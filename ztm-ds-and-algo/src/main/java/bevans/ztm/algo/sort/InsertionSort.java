package bevans.ztm.algo.sort;

public class InsertionSort {
    static int SWAP_COUNT = 0;

    public void sort(int[] array) {
        var arrayLength = array.length;

        for (int i = 1; i < arrayLength; i++) {
            var current = i;

            while (current > 0 && array[current] < array[current - 1]) {
                var temp = array[current - 1];
                array[current - 1] = array[current];
                array[current] = temp;
                current--;

                SWAP_COUNT++;
            }
        }
    }
}

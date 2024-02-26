package bevans.ztm.algo.sort;

public class BubbleSort {
    static int SWAP_COUNT = 0;

    public void sort(int[] array) {
        var arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                var temp = array[i];

                if (array[i] < array[j]) {
                    SWAP_COUNT++;
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

package bevans.ztm.algo.sort;

public class BubbleSort {
    static int SWAP_COUNT = 0;

    public void sort(int[] array) {
        var arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                var next = j + 1;

                if (array[j] > array[next]) {
                    SWAP_COUNT++;

                    var temp = array[j];
                    array[j] = array[next];
                    array[next] = temp;
                }
            }
        }
    }
}

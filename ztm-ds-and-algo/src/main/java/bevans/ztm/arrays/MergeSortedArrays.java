package bevans.ztm.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    Integer[] merge(Integer[] array1, Integer[] array2) {

        if (array1.length == 0) {
            return Arrays.copyOf(array2, array2.length);
        }
        if (array2.length == 0) {
            return Arrays.copyOf(array1, array1.length);
        }

        var merged = new Integer[array1.length + array2.length];

        var array1Index = 0;
        var array1Item = array1[array1Index];
        var array2Index = 0;
        var array2Item = array2[array2Index];
        var mergedIndex = 0;

        while (array1Item != null || array2Item != null) {
            var addFromFirstArray = array1Index < array1.length && (array2Item == null || array1Item < array2Item);

            if (addFromFirstArray) {
                merged[mergedIndex] = array1Item;
                mergedIndex++;
                array1Index++;
                array1Item = array1Index < array1.length ? array1[array1Index] : null;
            } else {
                merged[mergedIndex] = array2Item;
                mergedIndex++;
                array2Index++;
                array2Item = array2Index < array2.length ? array2[array2Index] : null;
            }

            System.out.println("merged = " + Arrays.toString(merged));
        }

        return merged;
    }
}

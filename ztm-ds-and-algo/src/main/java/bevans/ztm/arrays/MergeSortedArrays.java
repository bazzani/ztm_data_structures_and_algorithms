package bevans.ztm.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class MergeSortedArrays {
    Integer[] merge(Integer[] array1, Integer[] array2) {

        if (array2.length == 0) {
            return array1;
        }
        if (array1.length == 0) {
            return array2;
        }

        var mergedArray = new Integer[array1.length + array2.length];
        var mergedItemCount = 0;

        var array1Index = 1;
        var array1Item = array1[0];
        var array2Index = 1;
        var array2Item = array2[0];

        while (array1Item != null || array2Item != null) {
            var useFirstArrayItem = array2Item == null || array1Item < array2Item;

            if (useFirstArrayItem) {
                mergedArray[mergedItemCount] = array1Item;
                array1Item = array1Index < array1.length ? array1[array1Index] : null;
                array1Index++;
            } else {
                mergedArray[mergedItemCount] = array2Item;
                array2Item = array2Index < array2.length ? array2[array2Index] : null;
                array2Index++;
            }
            mergedItemCount++;
        }

        var mergedToString = Arrays.stream(mergedArray)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
        System.out.println("mergedArray = " + mergedToString);

        return mergedArray;
    }
}

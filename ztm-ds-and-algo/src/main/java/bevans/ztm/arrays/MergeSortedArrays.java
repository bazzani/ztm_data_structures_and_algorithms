package bevans.ztm.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MergeSortedArrays {
    Object[] merge(Object[] array1, Object[] array2) {
        Object[] mergedArray = new Object[array1.length + array2.length];

        Set<Object> array2Values = new HashSet<>();
        for (int i = 0; i < array2.length; i++) {
            array2Values.add(array2[i]);
        }

        var mergedValueCounter = 0;

        for (int i = 0; i < array1.length; i++) {
            var value = array1[i];
            mergedArray[mergedValueCounter] = value;
            mergedValueCounter++;

            if (array2Values.contains(value)) {
                mergedArray[mergedValueCounter] = value;
                mergedValueCounter++;
            }
        }

        var mergedToString = Arrays.stream(mergedArray)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
        System.out.println("mergedArray = " + mergedToString);

        return mergedArray;
    }
}

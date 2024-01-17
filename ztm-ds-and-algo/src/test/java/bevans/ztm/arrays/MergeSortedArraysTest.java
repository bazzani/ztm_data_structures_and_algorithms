package bevans.ztm.arrays;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArraysTest {
    private MergeSortedArrays sut;

    @BeforeEach
    public void setup() {
        sut = new MergeSortedArrays();
    }

    @Test
    void shouldMergeSortedArrays() {
        // given
        var array1 = Arrays.array(0, 3, 4, 31);
        var array2 = Arrays.array(4, 6, 30);
        var expectedArray = Arrays.array(0, 3, 4, 4, 6, 30, 31);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }
}

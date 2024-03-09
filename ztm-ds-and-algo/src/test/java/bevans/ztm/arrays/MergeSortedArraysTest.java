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
    void shouldMergeSortedArraysSameSize() {
        // given
        var array1 = Arrays.array(0, 3, 4, 31);
        var array2 = Arrays.array(4, 6, 30, 32);
        var expectedArray = Arrays.array(0, 3, 4, 4, 6, 30, 31, 32);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }

    @Test
    void shouldMergeSortedArraysFirstIsLarger() {
        // given
        var array1 = Arrays.array(0, 3, 4, 31);
        var array2 = Arrays.array(4, 6, 30);
        var expectedArray = Arrays.array(0, 3, 4, 4, 6, 30, 31);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }

    @Test
    void shouldMergeSortedArraysSecondIsLarger() {
        // given
        var array1 = Arrays.array(0, 3, 4, 31);
        var array2 = Arrays.array(4, 6, 10, 15, 30);
        var expectedArray = Arrays.array(0, 3, 4, 4, 6, 10, 15, 30, 31);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }

    @Test
    void shouldMergeSortedArraysFirstIsEmpty() {
        // given
        var array1 = new Integer[]{};
        var array2 = Arrays.array(4, 6, 30);
        var expectedArray = Arrays.array(4, 6, 30);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }

    @Test
    void shouldMergeSortedArraysSecondIsEmpty() {
        // given
        var array1 = Arrays.array(0, 3, 4, 31);
        var array2 = new Integer[]{};
        var expectedArray = Arrays.array(0, 3, 4, 31);

        // when
        var mergedArray = sut.merge(array1, array2);

        // then
        assertArrayEquals(expectedArray, mergedArray);
    }
}

package bevans.ztm.algo.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {
    private MergeSort sut;

    @BeforeEach
    public void setup() {
        sut = new MergeSort();
    }

    @Test
    void shouldSort() {
        // given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        // when
        int[] sorted = sut.sort(array);

        System.out.println("sorted = " + Arrays.toString(sorted));
        // then
        int[] expected = {0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};
        assertArrayEquals(expected, sorted);
    }
}

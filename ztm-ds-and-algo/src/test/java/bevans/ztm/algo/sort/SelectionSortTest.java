package bevans.ztm.algo.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

    private SelectionSort sut;

    @BeforeEach
    public void setup() {
        sut = new SelectionSort();
    }

    @Test
    void shouldSort() {
        // given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        // when
        sut.sort(array);

        System.out.println("SWAP_COUNT = " + SelectionSort.SWAP_COUNT);

        // then
        int[] expected = {0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};
        assertArrayEquals(expected, array);
    }
}

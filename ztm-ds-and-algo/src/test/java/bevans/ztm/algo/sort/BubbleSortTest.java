package bevans.ztm.algo.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {
    private BubbleSort sut;

    @BeforeEach
    public void setup() {
        sut = new BubbleSort();
    }

    @Test
    void shouldSort() {
        // given
        int[] array = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        // when
        sut.sort(array);

        // then
        int[] expected = {0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283};
        assertArrayEquals(expected, array);
    }
}

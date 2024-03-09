package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraysTwoSumTest {

    private ArraysTwoSum sut;

    @BeforeEach
    public void setup() {
        sut = new ArraysTwoSum();
    }

    @Test
    void shouldGetIndices() {
        // given
        // when
        var result = sut.twoSum(new int[]{2, 7, 11, 15}, 9);

        // then
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void shouldGetIndices2() {
        // given
        // when
        var result = sut.twoSum(new int[]{3, 2, 4}, 6);

        // then
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void shouldGetIndices3() {
        // given
        // when
        var result = sut.twoSum(new int[]{3, 3}, 6);

        // then
        assertArrayEquals(new int[]{0, 1}, result);
    }
}

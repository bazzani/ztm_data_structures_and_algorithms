package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ArraysMoveZerosToEndTest {
    private ArraysMoveZerosToEnd sut;

    @BeforeEach
    public void setup() {
        sut = new ArraysMoveZerosToEnd();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldMoveZeroes(int[] data, int[] expected) {
        // given
        // when
        sut.moveZeroes(data);

        // then
        assertArrayEquals(expected, data);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldMoveZeroesTwo(int[] data, int[] expected) {
        // given
        // when
        sut.moveZeroesTwo(data);

        // then
        assertArrayEquals(expected, data);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                of(new int[]{0}, new int[]{0}),
                of(new int[]{1}, new int[]{1}),
                of(new int[]{1,2,3,4}, new int[]{1,2,3,4})
        );
    }
}

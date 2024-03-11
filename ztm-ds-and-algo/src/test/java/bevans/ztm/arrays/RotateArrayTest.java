package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

@Timeout(value = 1, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class RotateArrayTest {
    private RotateArray sut;

    @BeforeEach
    public void setup() {
        sut = new RotateArray();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldRotateArray(int[] data, int rotations, int[] expected) {
        // given
        // when
        sut.rotate(data, rotations);

        // then
        System.out.println("data = " + Arrays.toString(data));
        assertArrayEquals(expected, data);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldRotateArrayBrute(int[] data, int rotations, int[] expected) {
        // given
        // when
        sut.rotateBrute(data, rotations);

        // then
        System.out.println("data = " + Arrays.toString(data));
        assertArrayEquals(expected, data);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of(new int[]{1, 2, 3, 4, 5, 6, 7},
                        101,
                        new int[]{5, 6, 7, 1, 2, 3, 4}
                ), of(new int[]{-1, -100, 3, 99},
                        2,
                        new int[]{3, 99, -1, -100}
                ), of(new int[]{-1},
                        2,
                        new int[]{-1}
                ), of(new int[]{1, 2},
                        0,
                        new int[]{1, 2}
                ),
                of(new int[]{1, 2},
                        3,
                        new int[]{2, 1}
                ),
                of(new int[]{1, 2, 3},
                        3,
                        new int[]{1, 2, 3}
                ),
                of(new int[]{1, 2, 3},
                        4,
                        new int[]{3, 1, 2}
                ),
                of(IntStream.range(0, 100_000).toArray(),
                        54944,
                        IntStream.concat(
                                IntStream.range(45_056, 100_000),
                                IntStream.range(0, 45_056)
                        ).toArray()
                )
        );
    }
}

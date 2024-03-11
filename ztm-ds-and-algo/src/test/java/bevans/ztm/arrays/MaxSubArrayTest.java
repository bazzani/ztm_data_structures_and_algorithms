package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubArrayTest {
    private MaxSubArray sut;

    @BeforeEach
    public void setup() {
        sut = new MaxSubArray();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindMaxSubArray(int[] data, int maxSum) {
        // given
        // when
        int maxSubArray = sut.maxSubArray(data);

        // then
        assertThat(maxSubArray).isEqualTo(maxSum);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindMaxSubArrayCleanCode(int[] data, int maxSum) {
        // given
        // when
        int maxSubArray = sut.maxSubArrayCleanCode(data);

        // then
        assertThat(maxSubArray).isEqualTo(maxSum);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
                Arguments.of(new int[]{-1}, -1)
        );
    }
}

package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ArraysTwoSumTest {

    private ArraysTwoSum sut;

    @BeforeEach
    public void setup() {
        sut = new ArraysTwoSum();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldGetIndices(int[] data, int sum, int[] expected) {
        // given
        // when
        var indices = sut.twoSum(data, sum);

        // then
        assertThat(indices).isEqualTo(expected);

        // when
        indices = sut.twoSumOnePass(data, sum);

        // then
        assertThat(indices).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

}

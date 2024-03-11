package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class ArraysContainsDuplicateTest {
    private ArraysContainsDuplicate sut;

    @BeforeEach
    public void setup() {
        sut = new ArraysContainsDuplicate();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindDuplicates(int[] data, boolean expected) {
        // given
        // when
        boolean containsDuplicate = sut.containsDuplicate(data);

        // then
        assertEquals(expected, containsDuplicate);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of(new int[]{1, 2, 3, 1}, true),
                of(new int[]{1, 2, 3, 4}, false),
                of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}

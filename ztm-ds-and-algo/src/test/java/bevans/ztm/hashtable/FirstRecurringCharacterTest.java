package bevans.ztm.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class FirstRecurringCharacterTest {

    private FirstRecurringCharacter sut;

    @BeforeEach
    public void setup() {
        sut = new FirstRecurringCharacter();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindFirstRecurringCharacter(int[] data, String expected) {
        // given
        // when
        var found = sut.findFirstRecurringCharacter(data);

        // then
        assertThat(found).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                of(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}, "2"),
                of(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}, "1"),
                of(new int[]{2, 3, 4, 5}, null)
        );
    }
}

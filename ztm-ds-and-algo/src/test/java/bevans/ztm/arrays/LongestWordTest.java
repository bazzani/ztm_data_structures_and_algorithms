package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestWordTest {
    private LongestWord sut;

    @BeforeEach
    public void setup() {
        sut = new LongestWord();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldFindLongestWord(String sen, String expected) {
        // given
        // when
        var longest = sut.longestWord(sen);

        // then
        assertThat(longest).isEqualTo(expected);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("fun&!! time", "time"),
                Arguments.of("I love dogs", "love")
        );
    }
}

package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReverseStringTest {

    private ReverseString sut;

    @BeforeEach
    public void setup() {
        sut = new ReverseString();
    }

    @Test
    void shouldReverseCharacters() {
        // given
        // when
        var value = sut.reverse("Hi my name is barry!");

        // then
        assertThat(value).isEqualTo("!yrrab si eman ym iH");
    }
}

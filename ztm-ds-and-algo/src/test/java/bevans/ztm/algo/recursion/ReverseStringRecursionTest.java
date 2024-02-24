package bevans.ztm.algo.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseStringRecursionTest {
    private ReverseStringRecursion sut;

    @BeforeEach
    public void setup() {
        sut = new ReverseStringRecursion();
    }


    @Test
    void shouldReverseStringRecursive() {
        // given
        // when
        var yoyoMaster = sut.reverseStringRecursive("yoyo master");

        // then
        assertThat(yoyoMaster).isEqualTo("retsam oyoy");
    }

    @Test
    void shouldReverseStringRecursive_emptyString() {
        // given
        // when
        var reversed = sut.reverseStringRecursive("");

        // then
        assertThat(reversed).isEmpty();
    }
}

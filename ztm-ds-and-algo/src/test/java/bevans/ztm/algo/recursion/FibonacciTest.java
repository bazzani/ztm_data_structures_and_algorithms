package bevans.ztm.algo.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {
    private Fibonacci sut;

    @BeforeEach
    public void setup() {
        sut = new Fibonacci();
    }

    @Test
    void shouldGetFibonacciRecursive() {
        // given
        // when
        var value = sut.fibonacciRecursive(3);

        // then
        assertThat(value).isEqualTo(2);

        // when
        value = sut.fibonacciRecursive(8);

        // then
        assertThat(value).isEqualTo(21);
    }

    @Test
    void shouldGetFibonacciIterative() {
        // given
        // when
        var value = sut.fibonacciIterative(3);

        // then
        assertThat(value).isEqualTo(2);

        // when
        value = sut.fibonacciIterative(8);

        // then
        assertThat(value).isEqualTo(21);
    }
}

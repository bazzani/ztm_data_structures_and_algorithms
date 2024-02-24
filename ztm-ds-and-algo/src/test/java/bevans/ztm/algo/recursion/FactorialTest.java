package bevans.ztm.algo.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

    private Factorial sut;

    @BeforeEach
    public void setup() {
        sut = new Factorial();
    }

    @Test
    void shouldSolveFactorialRecursive() {
        // given
        // when
        var factorial = sut.factorialRecursive(5);

        // then
        assertThat(factorial).isEqualTo(120);
    }

    @Test
    void shouldSolveFactorialRecursive_zero() {
        // given
        // when
        var factorial = sut.factorialRecursive(0);

        // then
        assertThat(factorial).isZero();
    }

    @Test
    void shouldSolveFactorialIterative() {
        // given
        // when
        var factorial = sut.factorialIterative(5);

        // then
        assertThat(factorial).isEqualTo(120);
    }

    @Test
    void shouldSolveFactorialIterative_zero() {
        // given
        // when
        var factorial = sut.factorialIterative(0);

        // then
        assertThat(factorial).isZero();
    }
}

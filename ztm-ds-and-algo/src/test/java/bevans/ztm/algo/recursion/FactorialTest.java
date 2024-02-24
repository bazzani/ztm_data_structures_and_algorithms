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
        assertThat(factorial).isEqualTo(1);
    }

    @Test
    void shouldSolveFactorialRecursive_one() {
        // given
        // when
        var factorial = sut.factorialRecursive(1);

        // then
        assertThat(factorial).isOne();
    }

    @Test
    void shouldSolveFactorialRecursive_two() {
        // given
        // when
        var factorial = sut.factorialRecursive(2);

        // then
        assertThat(factorial).isEqualTo(2);
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
        assertThat(factorial).isEqualTo(1);
    }

    @Test
    void shouldSolveFactorialIterative_one() {
        // given
        // when
        var factorial = sut.factorialIterative(1);

        // then
        assertThat(factorial).isEqualTo(1);
    }

    @Test
    void shouldSolveFactorialIterative_two() {
        // given
        // when
        var factorial = sut.factorialIterative(2);

        // then
        assertThat(factorial).isEqualTo(2);
    }
}

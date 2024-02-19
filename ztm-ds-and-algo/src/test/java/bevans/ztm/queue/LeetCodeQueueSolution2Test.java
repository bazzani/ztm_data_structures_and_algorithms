package bevans.ztm.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCodeQueueSolution2Test {

    private LeetCodeQueueSolution2 sut;

    @BeforeEach
    void setUp() {
        sut = new LeetCodeQueueSolution2();
    }

    @Test
    void shouldPeek() {
        // given
        sut.push(1);
        sut.push(2);

        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isEqualTo(1);
    }

    @Test
    void shouldPeekWhenEmpty() {
        // given
        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isNull();
    }

    @Test
    void shouldPush() {
        // given
        // when
        sut.push(1);
        sut.push(2);

        // then
        assertThat(sut.empty()).isFalse();
    }

    @Test
    void shouldPop() {
        // given
        sut.push(1);
        sut.push(2);

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isEqualTo(1);
    }

    @Test
    void shouldPopUntilEmpty() {
        // given
        sut.push(1);
        sut.pop();

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isNull();
        assertThat(sut.empty()).isTrue();
    }

    @Test
    void shouldPopUntilEmpty2() {
        // given
        sut.push(1);
        sut.push(2);

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isEqualTo(1);

        var popped2 = sut.pop();
        assertThat(popped2).isEqualTo(2);
    }
}

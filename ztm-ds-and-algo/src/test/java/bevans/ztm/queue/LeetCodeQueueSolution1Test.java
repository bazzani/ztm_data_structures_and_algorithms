package bevans.ztm.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeetCodeQueueSolution1Test {

    private LeetCodeQueueSolution1 sut;

    @BeforeEach
    void setUp() {
        sut = new LeetCodeQueueSolution1();
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

        var queueString = sut.printQueue();
        assertThat(queueString).isEqualTo("[1,2]");

        System.out.println("sut = " + queueString);
    }

    @Test
    void shouldPeekWhenEmpty() {
        // given
        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isNull();
        var queueString = sut.printQueue();
        assertThat(queueString).isEqualTo("[]");

        System.out.println("sut = " + queueString);
    }

    @Test
    void shouldPush() {
        // given
        // when
        sut.push(1);
        sut.push(2);

        // then
        assertThat(sut.empty()).isFalse();
        var queueString = sut.printQueue();
        assertThat(queueString).isEqualTo("[1,2]");

        System.out.println("sut = " + queueString);
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
        var queueString = sut.printQueue();
        assertThat(queueString).isEqualTo("[2]");

        System.out.println("sut = " + queueString);
    }

    @Test
    void shouldPopUntilEmpty() {
        // given
        sut.push(1);
        sut.push(2);

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isEqualTo(1);

        var popped2 = sut.pop();
        assertThat(popped2).isEqualTo(2);

        var queueString = sut.printQueue();
        assertThat(queueString).isEqualTo("[]");

        System.out.println("sut = " + queueString);
    }
}

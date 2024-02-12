package bevans.ztm.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueTest {

    private Queue sut;

    @BeforeEach
    void setUp() {
        sut = new Queue();
    }

    @Test
    void shouldPeek() {
        // given
        sut.enqueue("Joy");

        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isEqualTo("Joy");
        System.out.println("sut = " + sut.printQueue());
    }

    @Test
    void shouldPeekWhenEmpty() {
        // given
        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isNull();
        System.out.println("sut = " + sut.printQueue());
    }

    @Test
    void shouldEnqueue() {
        // given
        // when
        sut.enqueue("Joy");
        sut.enqueue("Sam");

        // then
        assertThat(sut.isEmpty()).isFalse();
        System.out.println("sut = " + sut.printQueue());
    }

    @Test
    void shouldDequeue() {
        // given
        sut.enqueue("Joy");
        sut.enqueue("Sam");

        // when
        var dequeued = sut.dequeue();

        // then
        assertThat(dequeued).isEqualTo("Joy");
        System.out.println("sut = " + sut.printQueue());
    }

    @Test
    void shouldDequeueUntilEmpty() {
        // given
        sut.enqueue("Sam");
        sut.dequeue();

        // when
        var dequeued = sut.dequeue();

        // then
        assertThat(dequeued).isNull();
        System.out.println("sut = " + sut.printQueue());
    }
}

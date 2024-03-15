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
        sut.enqueue("Barry");

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
        assertThat(sut.printQueue()).isEqualTo("[Joy,Sam]");
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
        assertThat(sut.isEmpty()).isTrue();
        System.out.println("sut = " + sut.printQueue());
    }

    @Test
    void shouldPeekAfterDeque() {
        // given
        sut.enqueue("Joy");
        sut.enqueue("Barry");
        sut.dequeue();
        sut.dequeue();
        sut.enqueue("Sammy");
        sut.enqueue("Sammy2");
        sut.dequeue();
        sut.enqueue("Sammy3");

        // when
        var peeked = sut.peek();

        // then
        System.out.println("sut = " + sut.printQueue());
        System.out.println("sut = " + sut);
        assertThat(peeked).isEqualTo("Sammy2");
    }
}

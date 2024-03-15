package bevans.ztm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackWithArrayTest {

    private StackWithArray sut;

    @BeforeEach
    void setUp() {
        sut = new StackWithArray();
    }

    @Test
    void shouldPeek() {
        // given
        sut.push("google");
        sut.push("Udemy");

        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isEqualTo("Udemy");
        System.out.println("stack = " + sut.printStack());
    }

    @Test
    void shouldPeekEmptyStack() {
        // given
        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isNull();
        System.out.println("stack = " + sut.printStack());
    }

    @Test
    void shouldPush() {
        // given
        // when
        sut.push("google");
        sut.push("Udemy");

        // then
        assertThat(sut.isEmpty()).isFalse();
        assertThat(sut.peek()).isEqualTo("Udemy");
        System.out.println("stack = " + sut.printStack());
    }

    @Test
    void shouldPop() {
        // given
        sut.push("google");
        sut.push("Udemy.com");
        sut.push("ZTM.com");

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isEqualTo("ZTM.com");
        assertThat(sut.isEmpty()).isFalse();
        System.out.println("stack = " + sut.printStack());
    }

    @Test
    void shouldPopUntilEmpty() {
        // given
        sut.push("google");
        sut.push("Udemy.com");
        sut.push("ZTM.com");
        sut.pop();
        sut.pop();

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isEqualTo("google");
        assertThat(sut.isEmpty()).isTrue();
        System.out.println("stack = " + sut.printStack());
    }

    @Test
    void shouldPopAfterEmpty() {
        // given
        sut.push("ZTM.com");
        sut.pop();

        // when
        var popped = sut.pop();

        // then
        assertThat(popped).isNull();
        assertThat(sut.isEmpty()).isTrue();
        System.out.println("stack = " + sut.printStack());
    }
}

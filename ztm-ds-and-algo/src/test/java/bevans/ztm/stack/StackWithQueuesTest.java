package bevans.ztm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackWithQueuesTest {
    private StackWithQueues sut;

    @BeforeEach
    public void setup() {
        sut = new StackWithQueues();
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
        assertThat(sut.toString()).isEqualTo("{\"q1\":[\"google\",\"Udemy\"],\"q2\":[],\"top\":\"Udemy\"}");
        System.out.println("stack = " + sut);
    }

    @Test
    void shouldPeekEmptyStack() {
        // given
        // when
        var peeked = sut.peek();

        // then
        assertThat(peeked).isNull();
        assertThat(sut.toString()).isEqualTo("{\"q1\":[],\"q2\":[],\"top\":null}");
        System.out.println("stack = " + sut);
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
        assertThat(sut.toString()).isEqualTo("{\"q1\":[\"google\",\"Udemy\"],\"q2\":[],\"top\":\"Udemy\"}");
        System.out.println("stack = " + sut);
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
        assertThat(sut.toString()).isEqualTo("{\"q1\":[\"google\",\"Udemy.com\"],\"q2\":[],\"top\":\"Udemy.com\"}");
        System.out.println("stack = " + sut);
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
        assertThat(sut.toString()).isEqualTo("{\"q1\":[],\"q2\":[],\"top\":null}");
        System.out.println("stack = " + sut);
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
        assertThat(sut.toString()).isEqualTo("{\"q1\":[],\"q2\":[],\"top\":null}");
        System.out.println("stack = " + sut);
    }
}

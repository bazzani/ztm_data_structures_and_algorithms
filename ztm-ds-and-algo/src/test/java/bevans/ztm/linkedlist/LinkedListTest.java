package bevans.ztm.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void shouldCreateWithOneValue() {
        // given
        // when
        var sut = new LinkedList(10);

        // then
        assertThat(sut.length()).isEqualTo(1);
        System.out.println("sut = " + sut);
    }

    @Test
    void shouldAppendValue() {
        // given
        var sut = new LinkedList(10);

        // when
        sut.append(5);

        // then
        assertThat(sut.length()).isEqualTo(2);
        System.out.println("sut = " + sut);
    }

    @Test
    void shouldPrependValue() {
        // given
        var sut = new LinkedList(10);

        // when
        sut.prepend(5);

        // then
        assertThat(sut.length()).isEqualTo(2);

        System.out.println("sut = " + sut);
    }
}
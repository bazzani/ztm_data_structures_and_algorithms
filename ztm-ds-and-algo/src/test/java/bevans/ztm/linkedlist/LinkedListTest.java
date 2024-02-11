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

        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldInsertValue() {
        // given
        var sut = new LinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.insert(2, 99);

        // then
        assertThat(sut.length()).isEqualTo(4);
        assertThat(sut.printList()).isEqualTo("[10,5,99,16]");
        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldInsertValueAtTheHead() {
        // given
        var sut = new LinkedList(10);

        // when
        sut.insert(0, 99);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[99,10]");
        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldInsertValueWithLargeIndex() {
        // given
        var sut = new LinkedList(10);

        // when
        sut.insert(200, 99);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,99]");
        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldRemoveValue() {
        // given
        var sut = new LinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.remove(1);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,16]");
        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldRemoveLastValue() {
        // given
        var sut = new LinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.remove(2);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,5]");
        System.out.println("sut = " + sut.printList());
    }

    @Test
    void shouldReverseLinkedList() {
        // given
        var sut = new LinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        var reversed = sut.reverse();

        // then
        assertThat(reversed.printList()).isEqualTo("[16,5,10]");
        System.out.println("reversed.printList() = " + reversed.printList());
    }

    @Test
    void shouldReverseEmptyLinkedList() {
        // given
        var sut = new LinkedList();

        // when
        var reversed = sut.reverse();

        // then
        assertThat(reversed.printList()).isEqualTo("[]");
        System.out.println("reversed.printList() = " + reversed.printList());
    }

    @Test
    void shouldReverseSingleValueLinkedList() {
        // given
        var sut = new LinkedList(10);

        // when
        var reversed = sut.reverse();

        // then
        assertThat(reversed.printList()).isEqualTo("[10]");
        System.out.println("reversed.printList() = " + reversed.printList());
    }

    @Test
    void shouldReverseZtm() {
        // given
        var sut = new LinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        var reversed = sut.reverseZtm();

        // then
        assertThat(reversed.printList()).isEqualTo("[16,5,10]");
        System.out.println("reversed.printList() = " + reversed.printList());
    }
}

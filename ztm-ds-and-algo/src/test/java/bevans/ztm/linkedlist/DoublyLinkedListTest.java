package bevans.ztm.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoublyLinkedListTest {
    @Test
    void shouldCreateWithOneValue() {
        // given
        // when
        var sut = new DoublyLinkedList(10);

        // then
        assertThat(sut.length()).isEqualTo(1);
        assertThat(sut.printList()).isEqualTo("[10]");
        printList(sut);
    }

    @Test
    void shouldAppendValue() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.append(5);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,5]");
        printList(sut);
    }

    @Test
    void shouldPrependValue() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.prepend(5);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[5,10]");
        printList(sut);
    }

    @Test
    void shouldInsertValue() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.insert(2, 99);

        // then
        assertThat(sut.length()).isEqualTo(4);
        assertThat(sut.printList()).isEqualTo("[10,5,99,16]");
        printList(sut);
    }

    @Test
    void shouldInsertValueAtEnd() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.insert(3, 99);

        // then
        assertThat(sut.length()).isEqualTo(4);
        assertThat(sut.printList()).isEqualTo("[10,5,16,99]");
        printList(sut);
    }

    @Test
    void shouldInsertValueAtTheHead() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.insert(0, 99);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[99,10]");
        printList(sut);
    }

    @Test
    void shouldInsertValueWithLargeIndex() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.insert(200, 99);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,99]");
        printList(sut);
    }

    @Test
    void shouldRemoveValue() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.remove(1);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,16]");
        printList(sut);
    }

    @Test
    void shouldRemoveFirstValue() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.remove(0);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[5,16]");
        printList(sut);
    }

    @Test
    void shouldRemoveLastValue() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.remove(2);

        // then
        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.printList()).isEqualTo("[10,5]");
        printList(sut);
    }

    @Test
    void shouldRemoveAllValues() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(16);

        // when
        sut.remove(0);
        sut.remove(0);

        // then
        assertThat(sut.length()).isZero();
        assertThat(sut.printList()).isEqualTo("[]");
        printList(sut);
    }

    @Test
    void shouldReverseLinkedList() {
        // given
        var sut = new DoublyLinkedList(10);
        sut.append(5);
        sut.append(16);

        // when
        sut.reverse();

        // then
        assertThat(sut.printList()).isEqualTo("[16,5,10]");
        printList(sut);
    }

    @Test
    void shouldReverseEmptyLinkedList() {
        // given
        var sut = new DoublyLinkedList();

        // when
        sut.reverse();

        // then
        assertThat(sut.printList()).isEqualTo("[]");
        printList(sut);
    }

    @Test
    void shouldReverseSingleValueLinkedList() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.reverse();

        // then
        assertThat(sut.printList()).isEqualTo("[10]");
        printList(sut);
    }

    private void printList(DoublyLinkedList sut) {
        System.out.println("sut = " + sut.printList());
        System.out.println("sut = " + sut);
    }
}

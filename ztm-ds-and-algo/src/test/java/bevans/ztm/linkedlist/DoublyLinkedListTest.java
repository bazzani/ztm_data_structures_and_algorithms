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
        System.out.println("sut = " + sut);
    }

    @Test
    void shouldAppendValues() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.append(5);
        sut.append(16);

        // then
        assertThat(sut.length()).isEqualTo(3);
        System.out.println("sut.printList() = " + sut.printList());
        System.out.println("sut = " + sut);
    }

    @Test
    void shouldPrependValue() {
        // given
        var sut = new DoublyLinkedList(10);

        // when
        sut.prepend(5);

        // then
        assertThat(sut.length()).isEqualTo(2);

        System.out.println("sut = " + sut.printList());
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
        System.out.println("sut = " + sut.printList());
        System.out.println("sut = " + sut);
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
        System.out.println("sut = " + sut.printList());
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
        System.out.println("sut = " + sut.printList());
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
        System.out.println("sut = " + sut.printList());
    }
}

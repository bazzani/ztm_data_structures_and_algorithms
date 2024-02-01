package bevans.ztm.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void shouldCreateWithOneNode() {
        // given
        // when
        var sut = new LinkedList(10);

        // then
        assertThat(sut.length()).isEqualTo(1);
    }
}

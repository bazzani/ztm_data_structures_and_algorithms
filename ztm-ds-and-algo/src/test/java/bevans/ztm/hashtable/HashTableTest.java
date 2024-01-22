package bevans.ztm.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HashTableTest {
    private HashTable sut;

    @BeforeEach
    public void setup() {
        sut = new HashTable(10);
    }

    @Test
    void shouldSetValue() {
        // given
        // when
        sut.set("key1", 123);

        // then
        var value = sut.get("key1");
        assertThat(value).isEqualTo(123);
    }
}

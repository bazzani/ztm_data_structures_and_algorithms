package bevans.ztm.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    void shouldReturnNullForMissingKey() {
        // given
        // when
        sut.set("key1", 123);

        // then
        var value = sut.get("key2");
        assertThat(value).isNull();
    }

    @Test
    void shouldSetTwoValuesOnHashCollision() {
        // given
        sut.set("key1", 123);
        sut.set("Barry", 123);

        // when
        sut.set("Harry", 456);

        // then
        assertAll(
                () -> {
                    var value = sut.get("Barry");
                    assertThat(value).isEqualTo(123);
                },
                () -> {
                    var value = sut.get("Harry");
                    assertThat(value).isEqualTo(456);
                }
        );

        System.out.println("sut = " + sut);
    }

    @Test
    void shouldOverwriteValueWithExistingKey() {
        // given
        sut.set("Harry", 456);
        sut.set("Harry", 789);

        // when
        sut.set("Harry", 000);

        // then
        var value = sut.get("Harry");
        assertThat(value).isEqualTo(000);
    }

    @Test
    void shouldGetKeys() {
        // given
        sut.set("grapes", 10_000);
        sut.set("grapes2", 10_000);
        sut.set("apples", 54);
        sut.set("oranges", 2);

        // when
        var keys = sut.keys();

        // then
        assertThat(keys).contains("grapes", "grapes2", "apples", "oranges");
    }
}

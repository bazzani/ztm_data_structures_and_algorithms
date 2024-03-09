package bevans.ztm.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZTMArrayTest {

    private ZTMArray sut;

    @BeforeEach
    public void setup() {
        sut = new ZTMArray();
    }

    @Test
    void shouldCreateEmptyArray() {
        assertThat(sut.length()).isZero();
        assertThat(sut.get(0)).isNull();
    }

    @Test
    void shouldGet() {
        sut.push("foo");

        assertThat(sut.get(0)).isEqualTo("foo");
    }

    @Test
    void shouldPush() {
        int newLength = sut.push("foo");

        assertThat(newLength).isEqualTo(1);
        assertThat(sut.length()).isEqualTo(1);
    }

    @Test
    void shouldPop() {
        sut.push("foo");
        assertThat(sut.pop()).isEqualTo("foo");
        assertThat(sut.length()).isZero();
    }

    @Test
    void shouldDelete() {
        var anObject = new Object();

        sut.push("foo");
        sut.push(anObject);
        sut.push(2);

        var deletedItem = sut.delete(1);

        assertThat(deletedItem).isEqualTo(anObject);
        assertThat(sut.length()).isEqualTo(2);

        assertThat(sut.get(0)).isEqualTo("foo");
        assertThat(sut.get(1)).isEqualTo(2);
    }

    @Test
    void shouldDeleteLastItem() {
        var anObject = new Object();

        sut.push("foo");
        sut.push(anObject);
        sut.push(2);

        sut.delete(2);

        assertThat(sut.length()).isEqualTo(2);
        assertThat(sut.get(1)).isEqualTo(anObject);
    }

    @Test
    void shouldFollowExampleFromZTMExercise() {
        sut.push("hi");
        sut.push("you");
        sut.push("!");
        sut.delete(0);
        sut.push("are");
        sut.push("nice");
        sut.delete(1);

        assertThat(sut).hasToString("[you,are,nice]");
    }
}

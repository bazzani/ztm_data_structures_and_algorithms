package bevans.ztm.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstRecurringCharacterTest {

    private FirstRecurringCharacter sut;

    @BeforeEach
    public void setup() {
        sut = new FirstRecurringCharacter();
    }

    @Test
    void shouldFindFirstRecurringCharacter2() {
        // given
        // when
        var value = sut.findFirstRecurringCharacter(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4});

        // then
        assertThat(value).isEqualTo("2");
    }

    @Test
    void shouldFindFirstRecurringCharacter1() {
        // given
        // when
        var value = sut.findFirstRecurringCharacter(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4});

        // then
        assertThat(value).isEqualTo("1");
    }

    @Test
    void shouldNotFindFirstRecurringCharacter() {
        // given
        // when
        var value = sut.findFirstRecurringCharacter(new int[]{2, 3, 4, 5});

        // then
        assertThat(value).isNull();
    }
}

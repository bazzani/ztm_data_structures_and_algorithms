package bevans.ztm.tree;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {
    private BinarySearchTree sut;

    @BeforeEach
    public void setup() {
        sut = new BinarySearchTree();
    }

    @Test
    void shouldInsert() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // then
        var tree = sut.traverse(sut.root);
        var treeJson = ReflectionToStringBuilder.reflectionToString(tree, ToStringStyle.JSON_STYLE);
        System.out.println(treeJson);
        assertThat(treeJson).isEqualTo("{\"left\":{\"left\":{\"value\":1},\"right\":{\"value\":6},\"value\":4},\"right\":{\"left\":{\"value\":15},\"right\":{\"value\":170},\"value\":20},\"value\":9}");
    }

    @Test
    void shouldLookupAndFindNode() {
        // given
        final int VALUE_TO_LOOKUP = 6;

        //        9
        //   4          20
        // 1   6     15    170
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // when
        var node = sut.lookup(VALUE_TO_LOOKUP);

        // then
        assertThat(node.value).isEqualTo(VALUE_TO_LOOKUP);
        System.out.println("node = " + node);
    }

    @Test
    void shouldLookupAndNotFindNode() {
        // given
        //        9
        //   4          20
        // 1   6     15    170
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // when
        var node = sut.lookup(16);

        // then
        assertThat(node).isNull();
        System.out.println("node = " + node);
    }

    @Test
    void shouldLookupAndNotFindNodeInEmptyTree() {
        // given
        // when
        var node = sut.lookup(5);

        // then
        assertThat(node).isNull();
    }

    @Test
    void shouldRemove() {
        // given
        final int VALUE_TO_REMOVE = 20;

        //        9
        //   4          20
        // 1   6     15    170
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // when
        var removed = sut.remove(VALUE_TO_REMOVE);

        // then
        assertThat(removed.value).isEqualTo(VALUE_TO_REMOVE);

        var tree = sut.traverse(sut.root);
        var treeJson = ReflectionToStringBuilder.reflectionToString(tree, ToStringStyle.JSON_STYLE);
        System.out.println(treeJson);
        assertThat(treeJson).isEqualTo("{\"left\":{\"left\":{\"value\":1},\"right\":{\"value\":6},\"value\":4},\"right\":{\"left\":{\"value\":15},\"value\":170},\"value\":9}");
    }

    @Test
    void shouldNotRemoveMissing() {
        // given
        //        9
        //   4          20
        // 1   6     15    170
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // when
        var removed = sut.remove(12);

        // then
        assertThat(removed).isNull();
    }

    @Test
    void shouldPerformBreadthFirstSearch() {
        // given
        //        9
        //   4          20
        // 1   6     15    170
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);

        // when
        int[] bfsResult = sut.breadthFirstSearch();

        // then
        assertThat(Arrays.toString(bfsResult)).isEqualTo("[9, 4, 20, 1, 6, 15, 170]");
    }
}

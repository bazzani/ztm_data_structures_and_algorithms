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
        addDataToTree();
    }

    private void addDataToTree() {
        sut.insert(9);
        sut.insert(4);
        sut.insert(6);
        sut.insert(20);
        sut.insert(170);
        sut.insert(15);
        sut.insert(1);
    }

    @Test
    void shouldInsert() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when

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

        // when
        var node = sut.lookup(16);

        // then
        assertThat(node).isNull();
        System.out.println("node = " + node);
    }

    @Test
    void shouldLookupAndNotFindNodeInEmptyTree() {
        // given
        sut = new BinarySearchTree();

        // when
        var node = sut.lookup(5);

        // then
        assertThat(node).isNull();
    }

    @Test
    void shouldRemove_1_NoRightChild() {
        // Option 1: No right child
        //  if parent > current value, make left child a left child of parent
        //  if parent < current value, make left child a right child of parent

        // given
        final int VALUE_TO_REMOVE = 170;

        //        9
        //   4          20
        // 1   6     15    170

        // when
        var removed = sut.remove(VALUE_TO_REMOVE);

        // then
        assertThat(removed.value).isEqualTo(VALUE_TO_REMOVE);

        var tree = sut.traverse(sut.root);
        var treeJson = ReflectionToStringBuilder.reflectionToString(tree, ToStringStyle.JSON_STYLE);
        System.out.println(treeJson);
        assertThat(treeJson).isEqualTo("{\"left\":{\"left\":{\"value\":1},\"right\":{\"value\":6},\"value\":4},\"right\":{\"left\":{\"value\":15},\"value\":20},\"value\":9}");
    }

    @Test
    void shouldRemove_2_RightChildWhichDoesNotHaveALeftChild() {
        // Option 2: Right child which doesn't have a left child
        //  if parent > current, make right child a left child of the parent
        //  if parent < current, make right child a right child of the parent

        // given
        final int VALUE_TO_REMOVE = 20;

        //        9
        //   4          20
        // 1   6     15    170

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
    void shouldRemove_3_RightChildThatHasALeftChild() {
        // Option 3: Right child that has a left child

        // given
        final int VALUE_TO_REMOVE = 9;

        //        9
        //   4          20
        // 1   6     15    170

        // when
        var removed = sut.remove(VALUE_TO_REMOVE);

        // then
        assertThat(removed.value).isEqualTo(VALUE_TO_REMOVE);

        var tree = sut.traverse(sut.root);
        var treeJson = ReflectionToStringBuilder.reflectionToString(tree, ToStringStyle.JSON_STYLE);
        System.out.println(treeJson);
        assertThat(treeJson).isEqualTo("{\"left\":{\"left\":{\"value\":1},\"right\":{\"value\":6},\"value\":4},\"right\":{\"right\":{\"value\":170},\"value\":20},\"value\":15}");
    }

    @Test
    void shouldNotRemoveMissing() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

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

        // when
        int[] bfsResult = sut.breadthFirstSearch();

        // then
        assertThat(Arrays.toString(bfsResult)).isEqualTo("[9, 4, 20, 1, 6, 15, 170]");
    }

    @Test
    void shouldPerformBreadthFirstSearchR() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when
        int[] bfsResult = sut.breadthFirstSearchR();

        // then
        assertThat(Arrays.toString(bfsResult)).isEqualTo("[9, 4, 20, 1, 6, 15, 170]");
    }

    @Test
    void shouldPerformDepthFirstSearchInOrder() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when
        int[] dfsResult = sut.depthFirstSearchInOrder();

        // then
        assertThat(Arrays.toString(dfsResult)).isEqualTo("[1, 4, 6, 9, 15, 20, 170]");
    }

    @Test
    void shouldPerformDepthFirstSearchPreOrder() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when
        int[] dfsResult = sut.depthFirstSearchPreOrder();

        // then
        assertThat(Arrays.toString(dfsResult))
                .isEqualTo("[9, 4, 1, 6, 20, 15, 170]");
    }

    @Test
    void shouldPerformDepthFirstSearchPostOrder() {
        // given
        //        9
        //   4          20
        // 1   6     15    170

        // when
        int[] dfsResult = sut.depthFirstSearchPostOrder();

        // then
        assertThat(Arrays.toString(dfsResult))
                .isEqualTo("[1, 6, 4, 15, 170, 20, 9]");
    }
}

package bevans.ztm.tree;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            var currentNode = root;
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    Node lookup(int value) {
        var currentNode = root;

        while (currentNode != null) {
            if (value == currentNode.value) {
                return currentNode;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    Node remove(int value) {

        return null;
    }

    int[] breadthFirstSearch() {
        var result = new ArrayList<Integer>();

        return result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    int[] breadthFirstSearchR() {
        return null;
    }

    int[] depthFirstSearchInOrder() {
        var result = new ArrayList<Integer>();

        return dfsInOrder(root, result)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> dfsInOrder(Node currentNode, List<Integer> result) {
        return result;
    }

    int[] depthFirstSearchPreOrder() {
        var result = new ArrayList<Integer>();

        return dfsPreOrder(root, result)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> dfsPreOrder(Node currentNode, List<Integer> result) {
        return result;
    }

    int[] depthFirstSearchPostOrder() {
        var result = new ArrayList<Integer>();

        return dfsPostOrder(root, result).stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> dfsPostOrder(Node currentNode, List<Integer> result) {
        return result;
    }

    Node traverse(Node node) {
        var tree = new Node(node.value);
        tree.left = node.left == null ? null : traverse(node.left);
        tree.right = node.right == null ? null : traverse(node.right);

        return tree;
    }

    static class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            var builder = new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE);
            builder.setExcludeNullValues(true);
            return builder.build();
        }
    }
}

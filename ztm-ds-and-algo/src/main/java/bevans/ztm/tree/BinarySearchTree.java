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
        if (root == null) {
            return null;
        }

        var currentNode = root;
        Node parentNode = null;

        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else if (value == currentNode.value) {
                // we have a match, get to work

                if (currentNode.right == null) {
                    // Option 1: No right child
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (parentNode.value > currentNode.value) {
                            // if parent > current value, make left child a left child of parent
                            parentNode.left = currentNode.left;
                        } else if (parentNode.value < currentNode.value) {
                            // if parent < current value, make left child a right child of parent
                            parentNode.right = currentNode.left;
                        }
                    }
                    return currentNode;

                } else if (currentNode.right.left == null) {
                    // Option 2: Right child which doesn't have a left child
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        root = currentNode.right;
                    } else {
                        if (parentNode.value > currentNode.value) {
                            // if parent > current, make right child a left child of the parent
                            parentNode.left = currentNode.right;
                        } else if (parentNode.value < currentNode.value) {
                            // if parent < current, make right child a right child of the parent
                            parentNode.right = currentNode.right;
                        }
                    }
                    return currentNode;

                } else {
                    // Option 3: Right child that has a left child

                    // find the Right child's left most child
                    var leftmost = currentNode.right.left;
                    var leftmostParent = currentNode.right;

                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    // Parent's left subtree is now leftmost's right subtree
                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;

                    if (parentNode == null) {
                        root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = leftmost;
                        }
                    }

                    return currentNode;
                }
            }
        }

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

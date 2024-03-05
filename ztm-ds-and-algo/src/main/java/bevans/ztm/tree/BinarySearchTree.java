package bevans.ztm.tree;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
                if (newNode.value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    Node lookup(int value) {
        if (root == null) {
            return null;
        }

        var currentNode = root;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else if (value == currentNode.value) {
                return currentNode;
            }
        }

        return null;
    }

    Node remove(int value) {
        if (root == null) {
            return null;
        }

        Node currentNode = root;
        Node parentNode = null;
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else if (value == currentNode.value) {
                // Option 1, no right child
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            // if parent > current value, parent.left = left
                            parentNode.left = currentNode.left;
                        } else if (currentNode.value > parentNode.value) {
                            // if parent < current value, parent.right = left
                            parentNode.right = currentNode.left;
                        }
                    }
                } else if (currentNode.right.left == null) {
                    // Option 2: Right child which does not have a left child
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        currentNode.right.left = currentNode.left;

                        if (currentNode.value < parentNode.value) {
                            // if parent > current, parent.left = right
                            parentNode.left = currentNode.right;
                        } else if (currentNode.value > parentNode.value) {
                            // if parent < current, parent.right = right
                            parentNode.right = currentNode.right;
                        }
                    }
                } else if (currentNode.left != null) {
                    // Option 3: Right child that has a left child

                    // find the Right child's left most child
                    var leftmost = currentNode.right.left;
                    var leftmostParent = currentNode.right;
                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    // Parents left subtree is now leftmost's right subtree
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
                }

                return currentNode;
            }
        }

        return null;
    }

    int[] breadthFirstSearch() {
        var result = new ArrayList<Integer>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();

            result.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    int[] breadthFirstSearchR() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        var result = new ArrayList<Integer>();

        return breadthFirstSearchR(queue, result);
    }

    private int[] breadthFirstSearchR(Queue<Node> queue, List<Integer> results) {
        if (queue.isEmpty()) {
            return results.stream().mapToInt(Integer::intValue).toArray();
        }

        var currentNode = queue.poll();
        results.add(currentNode.value);

        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }

        return breadthFirstSearchR(queue, results);
    }

    int[] depthFirstSearchInOrder() {
        var result = new ArrayList<Integer>();

        return dfsInOrder(root, result).stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> dfsInOrder(Node currentNode, List<Integer> result) {
        if (currentNode.left != null) {
            dfsInOrder(currentNode.left, result);
        }

        result.add(currentNode.value);

        if (currentNode.right != null) {
            dfsInOrder(currentNode.right, result);
        }

        return result;
    }

    int[] depthFirstSearchPreOrder() {
        var result = new ArrayList<Integer>();

        return dfsPreOrder(root, result).stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> dfsPreOrder(Node currentNode, List<Integer> result) {
        result.add(currentNode.value);

        if (currentNode.left != null) {
            dfsPreOrder(currentNode.left, result);
        }
        if (currentNode.right != null) {
            dfsPreOrder(currentNode.right, result);
        }

        return result;
    }

    int[] depthFirstSearchPostOrder() {
        var result = new ArrayList<Integer>();

        return dfsPostOrder(root, result).stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> dfsPostOrder(Node currentNode, List<Integer> result) {
        if (currentNode.left != null) {
            dfsPostOrder(currentNode.left, result);
        }
        if (currentNode.right != null) {
            dfsPostOrder(currentNode.right, result);
        }

        result.add(currentNode.value);

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

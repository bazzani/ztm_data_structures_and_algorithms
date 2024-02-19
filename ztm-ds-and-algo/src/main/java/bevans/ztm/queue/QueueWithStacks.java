package bevans.ztm.queue;

import java.util.StringJoiner;

public class QueueWithStacks {
    private Node first;
    private Node last;
    private int length;

    public Object peek() {
        return null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(String value) {
    }

    public Object dequeue() {
        return null;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        var currentNode = first;
        while (currentNode != null) {
            joiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }

        return joiner.toString();
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}

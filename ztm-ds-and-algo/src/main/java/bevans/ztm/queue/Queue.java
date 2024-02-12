package bevans.ztm.queue;

import java.util.StringJoiner;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Object peek() {
        if (length == 0) {
            return null;
        } else {
            return first.value;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(String value) {
        var newNode = new Node(value);

        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public Object dequeue() {
        if (first == null) {
            return null;
        }

        var dequeued = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        length--;

        return dequeued.value;
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

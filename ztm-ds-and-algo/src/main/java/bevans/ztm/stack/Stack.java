package bevans.ztm.stack;

import java.util.StringJoiner;

public class Stack {

    private Node top;
    private Node bottom;
    private int length;

    public Object peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top.value;
        }
    }

    public void push(Object value) {
        top = new Node(value, top);

        if (length == 0) {
            bottom = top;
        }

        length++;
    }

    public Object pop() {
        var popped = top.value;
        top = top.next;
        length--;

        if (length == 0) {
            bottom = null;
        }

        return popped;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String printStack() {
        var joiner = new StringJoiner(",", "[", "]");

        var current = top;
        while (current != null) {
            joiner.add(current.value.toString());
            current = current.next;
        }

        return joiner.toString();
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

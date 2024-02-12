package bevans.ztm.stack;

import org.w3c.dom.Node;

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
        if (length == 0) {
            var newNode = new Node(value, null);
            top = newNode;
            bottom = newNode;
        } else {
            var newNode = new Node(value, top);
            top = newNode;
        }
        length++;
    }

    public Object pop() {
        if (top == null) {
            return null;
        }

        if (top == bottom) {
            bottom = null;
        }

        var popped = top.value;
        top = top.next;
        length--;

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

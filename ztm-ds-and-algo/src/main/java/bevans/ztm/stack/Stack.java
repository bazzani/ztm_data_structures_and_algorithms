package bevans.ztm.stack;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class Stack {
    private Node top;
    private Node bottom;
    private int length;

    public Object peek() {
        if (top != null) {
            return top.value;
        } else {
            return null;
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
        if (top == null) {
            return null;
        }
        if (top == bottom) {
            bottom = null;
        }

        var popped = top;
        top = popped.next;
        length--;

        return popped.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String printStack() {
        var joiner = new StringJoiner(",", "[", "]");

        var currentNode = top;
        while (currentNode != null) {
            joiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
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

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}

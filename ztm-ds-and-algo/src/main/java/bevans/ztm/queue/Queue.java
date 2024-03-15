package bevans.ztm.queue;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class Queue {
    Node head;
    Node tail;
    int length;

    public Object peek() {
        if (head != null) {
            return head.value;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(Object value) {
        var newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Object dequeue() {
        if (head == null) {
            return null;
        }

        var dequeued = head;
        head = dequeued.next;
        length--;

        if (length == 0) {
            tail = null;
        }

        return dequeued.value;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        var currentNode = head;
        while (currentNode != null) {
            joiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }

        return joiner.toString();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
        }
    }
}

package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(Object value) {
        this.head = new Node(value, null);
        this.tail = head;
        this.length = 1;
    }

    public int length() {
        return length;
    }

    public void append(Object value) {
        var newNode = new Node(value, null);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(Object value) {
        var newNode = new Node(value, head);
        head = newNode;
        length++;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }

    private class Node {
        Object value;
        Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
        }
    }
}

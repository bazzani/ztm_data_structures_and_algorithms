package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(Object value) {
        this.head = new Node(value, null, null);
        this.tail = head;
        this.length = 1;
    }

    public int length() {
        return length;
    }

    public void append(Object value) {
        var newNode = new Node(value, null, head);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(Object value) {
        var newNode = new Node(value, head, null);
        head = newNode;
        length++;
    }

    public void insert(int index, Object value) {
        if (index >= length) {
            append(value);
        } else if (index == 0) {
            prepend(value);
        } else {
            var leader = traverseToIndex(index - 1);
            var holdingPointer = leader.next;
            leader.next = new Node(value, holdingPointer, leader);
            length++;
        }
    }

    public void remove(int index) {
        var leader = traverseToIndex(index - 1);
        var nextNode = leader.next.next;
        leader.next = nextNode;
        nextNode.previous = leader;
        length--;
    }

    private Node traverseToIndex(int index) {
        var currentIndex = 0;
        var currentNode = head;

        while (currentIndex != index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }

    String printList() {
        var joiner = new StringJoiner(",", "[", "]");
        var currentNode = this.head;
        while (currentNode != null) {
            joiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        return joiner.toString();
    }

    private static class Node {
        Object value;
        Node next;
        Node previous;

        public Node(Object value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
        }
    }
}

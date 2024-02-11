package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
    }

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

    public void insert(int index, Object value) {
        if (index >= length) {
            append(value);
        } else if (index == 0) {
            prepend(value);
        } else {
            var leader = traverseToIndex(index - 1);
            var holdingPointer = leader.next;
            leader.next = new Node(value, holdingPointer);
            length++;
        }
    }

    public void remove(int index) {
        var leader = traverseToIndex(index - 1);
        var unwantedNode = leader.next;
        leader.next = unwantedNode.next;
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

    public LinkedList reverse() {
        if (this.length > 0) {
            var currentHead = this.head;
            var reversed = new LinkedList(currentHead.value);

            while (currentHead.next != null) {
                reversed.prepend(currentHead.next.value);
                currentHead = currentHead.next;
            }

            return reversed;
        } else {
            return new LinkedList();
        }
    }

    public LinkedList reverseZtm() {
        if (this.head.next == null) {
            return this;
        }

        var first = this.head;
        this.tail = this.head;
        var second = first.next;

        while (second != null) {
            var temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        this.head.next = null;
        this.head = first;

        return this;
    }

    public void reverseBarry() {
        if (this.head.next == null) {
            return;
        }

        var first = this.head;
        this.tail = this.head;
        var second = first.next;

        while (second != null) {
            var temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }

        this.head.next = null;
        this.head = first;
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
            return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
        }
    }
}

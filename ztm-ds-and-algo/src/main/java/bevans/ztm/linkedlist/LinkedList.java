package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class LinkedList {

    private int length;
    private Node head;
    private Node tail;

    public LinkedList() {
    }

    public LinkedList(Object value) {
        this.head = new Node(value);
        this.tail = head;
        this.length = 1;
    }

    public int length() {
        return length;
    }

    public void append(Object value) {
        var newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;

        length++;
    }

    public void prepend(Object value) {
        head = new Node(value, head);
        length++;
    }

    public void insert(int index, Object value) {
        if (index >= length) {
            append(value);
            return;
        }
        if (index == 0) {
            prepend(value);
            return;
        }

        var leader = traverseToIndex(index - 1);
        leader.next = new Node(value, leader.next);
        length++;
    }

    public void remove(int index) {
        if (index == 0) {
            var unwantedNode = traverseToIndex(index);
            head = unwantedNode.next;
            length--;

            if (length == index) {
                tail = head;
            }
        } else {
            var leader = traverseToIndex(index - 1);
            var unwantedNode = leader.next;
            leader.next = unwantedNode.next;

            length--;
            if (length == index) {
                tail = leader;
            }
        }
    }

    private Node traverseToIndex(int index) {
        var indexCount = 0;
        var currentNode = head;

        while (indexCount != index) {
            currentNode = currentNode.next;
            indexCount++;
        }

        return currentNode;
    }

    public void reverse() {
        var emptyOrSingleItemList = this.head == null || this.head.next == null;
        if (!emptyOrSingleItemList) {
            var first = head;
            tail = head;
            var second = first.next;

            while (second != null) {
                var temp = second.next;
                second.next = first;
                first = second;
                second = temp;
            }

            head.next = null;
            head = first;
        }
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }

    String printList() {
        var joiner = new StringJoiner(",", "[", "]");

        var currentNode = head;
        while (currentNode != null) {
            joiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }

        return joiner.toString();
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }
}

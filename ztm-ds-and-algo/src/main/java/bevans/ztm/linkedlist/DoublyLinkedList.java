package bevans.ztm.linkedlist;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.StringJoiner;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(Object value) {
        this.head = new Node(value);
        this.tail = head;
        this.length = 1;
    }

    public int length() {
        return length;
    }

    public void append(Object value) {
        var newNode = new Node(value, null, tail);

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        length++;
    }

    public void prepend(Object value) {
        var newNode = new Node(value, head, null);
        newNode.next.prev = newNode;
        head = newNode;

        length++;
    }

    public void insert(int index, Object value) {
        if (index == 0) {
            prepend(value);
        } else if (index >= length) {
            append(value);
        } else {
            var leader = traverseToIndex(index - 1);
            var follower = leader.next;
            var newNode = new Node(value, follower, leader);
            leader.next = newNode;
            follower.prev = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            var unwantedNode = head;
            head = unwantedNode.next;
            unwantedNode.next = null;
            length--;
        } else {
            var leader = traverseToIndex(index - 1);
            var unwantedNode = leader.next;
            var follower = unwantedNode.next;

            leader.next = follower;
            if (follower != null) {
                follower.prev = leader;
            }
            tail = leader.next;

            length--;
            if (length == index) {
                tail = leader;
            }
        }

        if (length == 1) {
            tail = head;
        }
        if (length == 0) {
            tail = null;
            head = null;
        }
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
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
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

    public void reverse() {
        var emptyOrSingleItemList = length <= 1;

        if (!emptyOrSingleItemList) {
            tail = head;
            var first = head;
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

    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
        }

        Node(Object value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            var joiner = new StringJoiner(",", "{", "}");
            var nextValue = next != null ? next.value.toString() : null;
            var prevValue = prev != null ? prev.value.toString() : null;

            joiner.add("value:" + value + ", next:" + nextValue + ", prev:" + prevValue);
            return joiner.toString();
//            return new ReflectionToStringBuilder(this, RecursiveToStringStyle.JSON_STYLE).toString();
        }
    }
}

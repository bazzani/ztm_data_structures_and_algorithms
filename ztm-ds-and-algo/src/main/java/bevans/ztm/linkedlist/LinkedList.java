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
        this.head = new Node(value);
        this.tail = head;
        this.length = 1;
    }

    public int length() {
        return length;
    }

    public void append(Object value) {
        var newNode = new Node(value);

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        length++;
    }

    public void prepend(Object value) {
        head = new Node(value, head);
        length++;
    }

    public void insert(int index, Object value) {
        if (index == 0) {
            prepend(value);
        } else if (index >= length) {
            append(value);
        } else {
            var leader = traverseToIndex(index - 1);
            var temp = leader.next;
            leader.next = new Node(value, temp);
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
            leader.next = unwantedNode.next;
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

        Node(Object value) {
            this.value = value;
        }

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE).toString();
        }
    }
}

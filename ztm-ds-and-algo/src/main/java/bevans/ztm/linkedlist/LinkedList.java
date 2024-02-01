package bevans.ztm.linkedlist;

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
}

class Node {
    Object value;
    Node next;

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
}

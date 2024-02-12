package bevans.ztm.stack;

public class Stack {

    Node top;
    Node bottom;
    int length;

    public Object peek() {
        return null;
    }

    public void push(Object value) {

    }

    public Object pop() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}

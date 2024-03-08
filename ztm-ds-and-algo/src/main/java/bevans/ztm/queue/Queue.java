package bevans.ztm.queue;

import java.util.StringJoiner;

public class Queue {
    public Object peek() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void enqueue(Object value) {
    }

    public Object dequeue() {
        return null;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        return joiner.toString();
    }

    private static class Node {
    }
}

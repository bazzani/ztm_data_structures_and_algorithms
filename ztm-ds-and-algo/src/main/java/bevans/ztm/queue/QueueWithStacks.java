package bevans.ztm.queue;

import bevans.ztm.stack.StackWithArray;

import java.util.StringJoiner;

public class QueueWithStacks {

    public QueueWithStacks() {
    }

    public Object peek() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void enqueue(String value) {
    }

    public Object dequeue() {
        return null;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        // todo fix printing of rest elements in queue

        return joiner.toString();
    }
}

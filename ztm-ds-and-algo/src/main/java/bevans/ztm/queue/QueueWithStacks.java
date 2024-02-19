package bevans.ztm.queue;

import bevans.ztm.stack.StackWithArray;

import java.util.StringJoiner;

public class QueueWithStacks {
    private StackWithArray first;
    private StackWithArray rest;

    public QueueWithStacks() {
        this.first = new StackWithArray();
        this.rest = new StackWithArray();
    }

    public Object peek() {
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty() && rest.isEmpty();
    }

    public void enqueue(String value) {
        if (first.isEmpty()) {
            first.push(value);
        } else {
            rest.push(value);
        }
    }

    public Object dequeue() {
        if (first.isEmpty()) {
            return null;
        }

        var dequeued = first.pop();
        var tempStack = new StackWithArray();
        while (!rest.isEmpty()) {
            tempStack.push(rest.pop());
        }

        if (!tempStack.isEmpty()) {
            first.push(tempStack.pop());

            while (!tempStack.isEmpty()) {
                rest.push(tempStack.pop());
            }
        }

        return dequeued;
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        if (!first.isEmpty()) {
            joiner.add(first.peek().toString());
        }

        // todo fix printing of rest elements in queue
//        var currentNode = first;
//        while (currentNode != null) {
//            joiner.add(currentNode.value.toString());
//            currentNode = currentNode.next;
//        }
//
        return joiner.toString();
    }
}

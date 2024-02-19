package bevans.ztm.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class QueueWithArrayListStacks {
    private List<Object> first;
    private List<Object> rest;

    public QueueWithArrayListStacks() {
        this.first = new ArrayList<>();
        this.rest = new ArrayList<>();
    }

    public Object peek() {
        if (!first.isEmpty()) {
            return first.get(first.size() - 1);
        }

        if (rest.isEmpty()) {
            return null;
        } else {
            return rest.get(0);
        }
    }

    public boolean isEmpty() {
        return first.isEmpty() && rest.isEmpty();
    }

    public void enqueue(String value) {
        var length = first.size();

        for (int i = 0; i < length; i++) {
            rest.add(first.remove(first.size() - 1));
        }

        rest.add(value);
    }

    public Object dequeue() {
        var length = rest.size();

        for (int i = 0; i < length; i++) {
            first.add(rest.remove(0));
        }

        if (first.isEmpty()) {
            return null;
        } else {
            return first.remove(0);
        }
    }

    public String printQueue() {
        var joiner = new StringJoiner(",", "[", "]");

        if (!first.isEmpty()) {
            joiner.add(first.get(0).toString());
        }

        for (int i = 0; i < rest.size(); i++) {
            joiner.add(rest.get(i).toString());
        }

        return joiner.toString();
    }
}

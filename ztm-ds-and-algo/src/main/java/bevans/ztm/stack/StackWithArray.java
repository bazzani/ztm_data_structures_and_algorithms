package bevans.ztm.stack;

import java.util.ArrayList;
import java.util.StringJoiner;

public class StackWithArray {

    ArrayList<Object> data;

    public StackWithArray() {
        this.data = new ArrayList<>();
    }

    public Object peek() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.get(data.size() - 1);
        }
    }

    public void push(Object value) {
        data.add(value);
    }

    public Object pop() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.remove(data.size() - 1);
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public String printStack() {
        var joiner = new StringJoiner(",", "[", "]");

        for (var value : data) {
            joiner.add(value.toString());
        }

        return joiner.toString();
    }
}

package bevans.ztm.stack;

import java.util.StringJoiner;

public class StackWithArray {

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

    public String printStack() {
        var joiner = new StringJoiner(",", "[", "]");

        return joiner.toString();
    }
}
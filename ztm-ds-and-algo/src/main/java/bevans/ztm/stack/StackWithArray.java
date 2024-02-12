package bevans.ztm.stack;

import java.util.Arrays;
import java.util.StringJoiner;

public class StackWithArray {

    Object[] data;

    public StackWithArray() {
        this.data = new Object[]{};
    }

    public Object peek() {
        if (data.length == 0) {
            return null;
        } else {
            return data[data.length - 1];
        }
    }

    public void push(Object value) {
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = value;
    }

    public Object pop() {
        var popped = data[data.length - 1];
        data = Arrays.copyOf(data, data.length - 1);

        return popped;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public String printStack() {
        var joiner = new StringJoiner(",", "[", "]");

        for (int i = data.length - 1; i >= 0; i--) {
            joiner.add(data[i].toString());
        }

        return joiner.toString();
    }
}

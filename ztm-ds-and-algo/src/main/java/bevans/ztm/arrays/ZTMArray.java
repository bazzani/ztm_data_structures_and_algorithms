package bevans.ztm.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ZTMArray {
    private int length;
    private final Map<Integer, Object> data;

    public ZTMArray() {
        this.length = 0;
        this.data = new HashMap<>();
    }

    public Object get(int index) {
        return null;
    }

    public int push(Object item) {
        return 0;
    }

    public Object pop() {
        return null;
    }

    public Object delete(int position) {
        return null;
    }

    private void shiftItems(int position) {
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        return data.values()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}

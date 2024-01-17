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
        return data.get(index);
    }

    public int push(Object item) {
        data.put(this.length, item);
        length++;

        return length;
    }

    public Object pop() {
        var lastItem = data.remove(length - 1);
        length--;

        return lastItem;
    }

    public Object delete(int position) {
        var item = data.get(position);
        shiftItems(position);

        return item;
    }

    private void shiftItems(int position) {
        for (int i = position; i < length; i++) {
            var shiftedItem = data.get(i + 1);
            data.put(i, shiftedItem);
        }
        data.remove(length - 1);
        length--;
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

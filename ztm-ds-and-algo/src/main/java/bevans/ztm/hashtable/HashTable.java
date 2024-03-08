package bevans.ztm.hashtable;

import java.util.Arrays;

public class HashTable {
    private final Object[][][] data;

    HashTable(int size) {
        this.data = new Object[size][][];
    }

    void set(String key, Object value) {
    }

    Object get(String key) {
        return null;
    }

    private int hash(String key) {
        return 0;
    }

    String[] keys() {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.data);
    }
}

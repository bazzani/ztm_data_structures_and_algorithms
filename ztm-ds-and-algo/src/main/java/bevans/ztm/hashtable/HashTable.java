package bevans.ztm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    // todo implement with Array of LinkedList<HashTable$Entry>

    private final Object[][][] data;

    HashTable(int size) {
        this.data = new Object[size][][];
    }

    void set(String key, Object value) {
        var hash = hash(key);

        if (data[hash] == null) {
            data[hash] = new Object[][]{};
        }

        var hashValues = data[hash];
        var keyIndex = -1;

        for (int i = 0; i < hashValues.length; i++) {
            if (hashValues[i][0] == key) {
                keyIndex = i;
                break;
            }
        }

        if (keyIndex > -1) {
            hashValues[keyIndex][1] = value;
        } else {
            var newValues = new Object[hashValues.length + 1][];
            System.arraycopy(hashValues, 0, newValues, 0, hashValues.length);
            newValues[hashValues.length] = new Object[]{key, value};
            data[hash] = newValues;
        }
    }

    Object get(String key) {
        var hash = hash(key);

        var hashValues = data[hash];
        if (hashValues == null) {
            return null;
        }

        for (Object[] hashValue : hashValues) {
            if (hashValue[0] == key) {
                return hashValue[1];
            }
        }

        return null;
    }

    int hash(String key) {
        var hash = 0;
        for (var i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % data.length;
        }

        return hash;
    }

    String[] keys() {
        var keys = new ArrayList<String>();

        for (var hashCur = 0; hashCur < data.length; hashCur++) {
            if (data[hashCur] != null) {
                for (var keyCur = 0; keyCur < data[hashCur].length; keyCur++) {
                    keys.add(data[hashCur][keyCur][0].toString());
                }
            }
        }

        return keys.toArray(new String[]{});
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.data);
    }
}

package bevans.ztm.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class HashTable {
    private final Object[][][] data;

    HashTable(int size) {
        this.data = new Object[size][][];
    }

    void set(String key, Object value) {
        var address = hash(key);
        Object[][] bucket = data[address];

        if (bucket == null) {
            bucket = new Object[1][];
            data[address] = bucket;
        } else {
            var keyIndex = getKeyIndex(key, bucket);

            if (keyIndex > -1) {
                bucket[keyIndex][1] = value;
            } else {
                bucket = createLargerBucket(bucket);
                data[address] = bucket;
            }
        }

        var newEntry = new Object[2];
        newEntry[0] = key;
        newEntry[1] = value;
        bucket[bucket.length - 1] = newEntry;
    }

    private int getKeyIndex(String key, Object[][] bucket) {
        var keyIndex = -1;

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] == key) {
                keyIndex = i;
                break;
            }
        }

        return keyIndex;
    }

    private Object[][] createLargerBucket(Object[][] bucket) {
        var largerBucket = new Object[bucket.length + 1][];

        System.arraycopy(bucket, 0,
                largerBucket, 0,
                bucket.length);

        return largerBucket;
    }

    Object get(String key) {
        Object value = null;

        var address = hash(key);
        Object[][] currentBucket = data[address];

        if (currentBucket != null) {
            for (int i = 0; i < currentBucket.length; i++) {
                if (currentBucket[i][0].equals(key)) {
                    value = currentBucket[i][1];
                }
            }
        }

        return value;
    }

    private int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            int charCode = key.charAt(i);
            hash = (hash + charCode * i) % data.length;
        }

        return hash;
    }

    String[] keys() {
        var keySet = new HashSet<String>();

        for (Object[][] currentBucket : data) {
            if (currentBucket != null) {
                if (currentBucket.length == 1) {
                    keySet.add(currentBucket[0][0].toString());
                } else {
                    for (Object[] objects : currentBucket) {
                        keySet.add(objects[0].toString());
                    }
                }
            }
        }

        return keySet.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.data);
    }
}

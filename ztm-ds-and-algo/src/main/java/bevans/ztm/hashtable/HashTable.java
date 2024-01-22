package bevans.ztm.hashtable;

public class HashTable {
    private final Object[][] data;

    HashTable(int size) {
        this.data = new Object[size][];
    }

    void set(String key, Object value) {
        var bucketIndexHash = hash(key);
        Object[] bucket = data[bucketIndexHash];

        if (bucket == null) {
            bucket = new Object[2];
            data[bucketIndexHash] = bucket;
        }

        bucket[0] = key;
        bucket[1] = value;
    }

    Object get(String key) {
        Object value = null;

        var bucketIndexHash = hash(key);
        Object[] bucket = data[bucketIndexHash];

        if (bucket != null && (bucket[0] == key)) {
            value = bucket[1];
        }

        return value;
    }

    int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            int charCode = key.charAt(i);
            hash = (hash + charCode * i) % data.length;
        }

        return hash;
    }
}

package bevans.ztm.hashtable;

class FirstRecurringCharacter {
    String findFirstRecurringCharacter(int[] input) {
        var foundValues = new HashTable(10);
        String recurringValue = null;

        for (int i : input) {
            var value = String.valueOf(i);

            if (foundValues.get(value) != null) {
                recurringValue = value;
                break;
            } else {
                foundValues.set(value, value);
            }
        }

        return recurringValue;
    }
}

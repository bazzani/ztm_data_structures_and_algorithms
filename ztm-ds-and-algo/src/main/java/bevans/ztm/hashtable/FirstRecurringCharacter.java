package bevans.ztm.hashtable;

import java.util.HashSet;

class FirstRecurringCharacter {
    String findFirstRecurringCharacter(int[] input) {
        var found = new HashSet<Integer>();

        for (int chr : input) {
            if (found.contains(chr)) {
                return Integer.toString(chr);
            }
            found.add(chr);
        }

        return null;
    }
}

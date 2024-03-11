package bevans.ztm.arrays;

import java.util.HashSet;

public class ArraysContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        var found = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (found.contains(num)) {
                return true;
            } else {
                found.add(num);
            }
        }

        return false;
    }
}

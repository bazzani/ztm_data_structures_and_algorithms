package bevans.ztm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */

public class ArraysTwoSum {
    public int[] twoSum(int[] nums, int target) {
        var valueToIndex = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            var complementKey = target - nums[i];

            if (valueToIndex.containsKey(complementKey) && valueToIndex.get(complementKey) != i) {
                return new int[]{i, valueToIndex.get(complementKey)};
            }
        }

        return new int[]{};
    }

    //Approach 3: One-pass Hash Table
    //Algorithm
    //
    //It turns out we can do it in one-pass. While we are iterating and inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table. If it exists, we have found a solution and return the indices immediately.
    //
    //Implementation
    public int[] twoSumOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}

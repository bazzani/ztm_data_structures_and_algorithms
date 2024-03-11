package bevans.ztm.arrays;

public class ArraysMoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        var lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesTwo(int[] nums) {
        var lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];

                if (lastNonZeroFoundAt - 1 != i) {
                    nums[i] = 0;
                }
            }
        }
    }
}

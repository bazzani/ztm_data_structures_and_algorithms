package bevans.ztm.arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        var length = nums.length;
        k = k % length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] data, int startPos, int endPos) {
        while (startPos < endPos) {
            swap(data, startPos, endPos);
            startPos++;
            endPos--;
        }
    }

    private void swap(int[] data, int pos1, int pos2) {
        var temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }

    public void rotateBrute(int[] data, int rotations) {
        var length = data.length;

        for (int rCur = 0; rCur < rotations; rCur++) {
            var temp = data[length - 1];

            for (int i = 0; i < length; i++) {
                var t = data[i];
                data[i] = temp;
                temp = t;
            }
        }
    }
}

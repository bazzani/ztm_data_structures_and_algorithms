package bevans.ztm.arrays;

public class ReverseString {
    public String reverse(String input) {
        char[] reversed = new char[input.length()];

        var charArray = input.toCharArray();
        var inputCharCount = charArray.length - 1;

        for (int i = inputCharCount; i >= 0; i--) {
            reversed[inputCharCount - i] = charArray[i];
        }

        return new String(reversed);
    }
}

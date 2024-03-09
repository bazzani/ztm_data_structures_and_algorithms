package bevans.ztm.arrays;

public class ReverseString {
    public String reverse(String input) {
        var chars = input.toCharArray();
        var reversedChars = new char[chars.length];

        for (int i = chars.length - 1; i >= 0; i--) {
            reversedChars[chars.length - i - 1] = chars[i];
        }

        return new String(reversedChars);
    }
}

package bevans.ztm.algo.recursion;

public class ReverseStringRecursion {
    String reverseStringRecursive(String str) {
        if (str.length() == 1) {
            return str;
        }

        return str.charAt(str.length() - 1) + reverseStringRecursive(str.substring(0, str.length() - 1));
    }
}

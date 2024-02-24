package bevans.ztm.algo.recursion;

public class ReverseStringRecursion {
    String reverseStringRecursive(String str) {
        if (str.isEmpty()) {
            return "";
        }

        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
}

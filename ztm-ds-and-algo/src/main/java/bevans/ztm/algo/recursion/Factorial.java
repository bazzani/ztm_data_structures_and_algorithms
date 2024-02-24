package bevans.ztm.algo.recursion;

public class Factorial {
    public int factorialRecursive(int input) {
        if (input < 2) {
            return input;
        }

        return input * factorialRecursive(input - 1);
    }

    public int factorialIterative(int input) {
        var result = input;

        for (int i = input - 1; i > 0; i--) {
            result = result * i;
        }

        return result;
    }
}

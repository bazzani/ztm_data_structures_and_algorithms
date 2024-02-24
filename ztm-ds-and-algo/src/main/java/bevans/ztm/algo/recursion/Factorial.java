package bevans.ztm.algo.recursion;

public class Factorial {
    public int factorialRecursive(int input) {
        if (input == 0) {
            return 1;
        }

        if (input == 2) {
            return 2;
        }

        return input * factorialRecursive(input - 1);
    }

    public int factorialIterative(int input) {
        var result = 1;

        for (int i = 2; i <= input; i++) {
            result = result * i;
        }

        return result;
    }
}

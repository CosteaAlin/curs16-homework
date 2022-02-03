package ro.fasttrackit.recursion;

public class RecursiveFunctions {

    public static int sumOfIntegers(int n) {
        if (n > 0) {
            return n + sumOfIntegers(n - 1);
        }
        return 0;
    }

    public static int sumOfEvenIntegers(int n) {
        if (n <= 0) {
            return 0;
        } else if (n % 2 == 0) {
            return n + sumOfEvenIntegers(n - 2);
        } else {
            return (n - 1) + sumOfEvenIntegers(n - 3);
        }
    }

    public static boolean palindromeCheckFirstAndLastLetter(String word, int start, int end) {
        if (word == null) {
            throw new IllegalArgumentException("You are not allowed to pass null as parameter");
        }
        if (start == end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        if (start + 1 > end) {
            palindromeCheckFirstAndLastLetter(word, start + 1, end - 1);
        }
        return true;
    }

    public static boolean palindromeCheckStringReverse(String word) {
        if (word == null) {
            throw new IllegalArgumentException("You are not allowed to pass null as parameter");
        }
        return word.equalsIgnoreCase(reverseString(word));
    }

    private static String reverseString(String word) {
        if (word.length() <= 1) {
            return word;
        }
        return reverseString(word.substring(1)) + word.charAt(0);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.abs(n % 10) + sumOfDigits(n / 10);
    }

    public static int fibonacci(int element) {
        if (element <= 1) {
            return element;
        }
        return fibonacci(element - 1) + fibonacci(element - 2);
    }
}

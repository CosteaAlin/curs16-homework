package ro.fasttrackit.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecursiveFunctionsTest {

    @Test
    void testSumOfIntegers() {
        assertThat(RecursiveFunctions.sumOfIntegers(-4)).isEqualTo(0);
        assertThat(RecursiveFunctions.sumOfIntegers(3)).isEqualTo(6);
        assertThat(RecursiveFunctions.sumOfIntegers(4)).isEqualTo(10);
    }

    @Test
    void testSumOfEvenIntegers() {
        assertThat(RecursiveFunctions.sumOfEvenIntegers(3)).isEqualTo(2);
        assertThat(RecursiveFunctions.sumOfEvenIntegers(10)).isEqualTo(30);
        assertThat(RecursiveFunctions.sumOfEvenIntegers(-7)).isEqualTo(0);
    }

    @Test
    void testPalindromeCheckFirstAndLastLetter() {
        assertThat(RecursiveFunctions.palindromeCheckFirstAndLastLetter("ana", 0, 2)).isTrue();
        assertThat(RecursiveFunctions.palindromeCheckFirstAndLastLetter("madam", 0, 4)).isTrue();
        assertThat(RecursiveFunctions.palindromeCheckFirstAndLastLetter("alin", 0, 2)).isFalse();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> RecursiveFunctions.palindromeCheckFirstAndLastLetter(null, 0, 0));
        assertThat(e.getMessage()).isEqualTo("You are not allowed to pass null as parameter");
    }

    @Test
    void testPalindromeCheckStringReverse() {
        assertThat(RecursiveFunctions.palindromeCheckStringReverse("ana")).isTrue();
        assertThat(RecursiveFunctions.palindromeCheckStringReverse("madam")).isTrue();
        assertThat(RecursiveFunctions.palindromeCheckStringReverse("alin")).isFalse();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> RecursiveFunctions.palindromeCheckStringReverse(null));
        assertThat(e.getMessage()).isEqualTo("You are not allowed to pass null as parameter");
    }

    @Test
    void testSumOfDigits() {
        assertThat(RecursiveFunctions.sumOfDigits(123)).isEqualTo(6);
        assertThat(RecursiveFunctions.sumOfDigits(-123)).isEqualTo(6);
        assertThat(RecursiveFunctions.sumOfDigits(0)).isEqualTo(0);
    }

    @Test
    void testFibonacci() {
        assertThat(RecursiveFunctions.fibonacci(0)).isEqualTo(0);
        assertThat(RecursiveFunctions.fibonacci(1)).isEqualTo(1);
        assertThat(RecursiveFunctions.fibonacci(7)).isEqualTo(13);
    }
}

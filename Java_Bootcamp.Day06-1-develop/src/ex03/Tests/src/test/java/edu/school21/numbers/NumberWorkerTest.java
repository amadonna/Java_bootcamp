package edu.school21.numbers;

import edu.school21.exceptions.IllegalNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker nw;

    @BeforeEach
    void beforeEachMethod() { nw = new NumberWorker(); }

    @ParameterizedTest
    @ValueSource (ints  = {95219, 11329, 10091, 2})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {91239, 12319, 19011, 24})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, -1, -102, -54547})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(IllegalNumberException.class, () -> nw.isPrime(number));
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void checkSumOfDigits(int number, int sum) {
        Assertions.assertEquals(sum, nw.digitsSum(number));
    }

}

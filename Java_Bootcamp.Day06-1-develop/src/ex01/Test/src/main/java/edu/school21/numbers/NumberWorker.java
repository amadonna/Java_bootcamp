package edu.school21.numbers;

import edu.school21.exeptions.IllegalNumberException;

public class NumberWorker {
    public NumberWorker() {}
    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalNumberException();
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int digitsSum(int number) {
        int sum = 0;
        while (number % 10 != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

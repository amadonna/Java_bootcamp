package src.ex02;

import java.util.Scanner;
public class Program {
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number % 10 != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isSimple(int number) {
        boolean result = false;
        if (number > 1) {
            int i = 2;
            while (number % i != 0) {
                i++;
            }
            if (i == number) {
                result = true;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int check = 0;
        while (n != 42) {
            n = scanner.nextInt();
            if (isSimple(sumOfDigits(n))) {
                check++;
            }
        }
        System.out.printf("Count of coffee - request - %d\n", check);
        scanner.close();
    }
}

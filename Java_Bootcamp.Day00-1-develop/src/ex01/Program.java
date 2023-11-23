package src.ex01;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int iterator = 1;
        if (number < 2) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else {
            int i = 2;
            while (i * i < number && number % i != 0) {
                iterator++;
                i++;
            }
            if (number % i != 0) {
                System.out.print("true ");
            }
            else {
                System.out.print("false ");
            }
            System.out.printf("%d\n", iterator);
        }
        scanner.close();
    }
}
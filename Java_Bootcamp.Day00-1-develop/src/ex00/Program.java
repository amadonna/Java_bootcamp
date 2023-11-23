package src.ex00;

public class Program {
    public static void main (String[] args) {
        int number = 479598;
        int sum = 0;
        int check = 0;
        while (number % 10 != 0) {
            sum += number % 10;
            number /= 10;
            check++;
        }
        if (check == 6) {
            System.out.println(sum);
        }
    }

}
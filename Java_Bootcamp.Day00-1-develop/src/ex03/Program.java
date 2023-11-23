package src.ex03;
import java.util.Scanner;

public class Program {

    public static void exitError() {
        System.err.println("IllegalArgument");
        System.exit(-1);
    }
    public static int getResults(Scanner scanner) {
        int  result = 9;
        int current = 0;
        for (int i = 0; i < 5; i++) {
            if (scanner.hasNextInt()) {
                current = scanner.nextInt();
            }
            if (current > 0 && current < 10) {
                if (current < result) {
                    result = current;
                }
            }
            else {
                exitError();
            }
        }
        return result;
    }
    public static String getWeek (Scanner scanner) {
        String isWeek = "";
        if (scanner.hasNext()) {
            isWeek = scanner.next();
            if (!isWeek.equals("Week") && !isWeek.equals("42")) {
                exitError();
            }
        }
        else {
            exitError();
        }
        return isWeek;
    }

    public static int getNumWeek (Scanner scanner) {
        int numberOfWeek = 0;
        if (scanner.hasNextInt()) {
            numberOfWeek = scanner.nextInt();
            if (!(numberOfWeek > 0 && numberOfWeek < 19)) {
                exitError();
            }
        }
        else  {
            exitError();
        }
        return numberOfWeek;
    }
    public static long makeResults(long results, int numOfWeek, int minOfWeek) {
        long temp = minOfWeek;
        for (int i = 0; i < 19 - numOfWeek; i++) {
            temp *= 10;
        }
        results += temp;
        return results;
    }

    public static void showResults(long results ) {
        long limit = 10;
        for (int i = 0; i < 17; i++) {
            limit *= 10;
        }
        long k;
        for (int j = 1; j < 19; j++) {
            k = results / limit;
            if (k != 0) {
                System.out.printf("Week %d ", j);
                for (int l = 0; l < (int)k; l++) {
                    System.out.print("=");
                }
                System.out.println(">");

            }
            results = results - k * limit;
            limit /= 10;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfWeek = 0;
        String isWeek = "";
        int numOfWeek;
        int minOfWeek;
        long results = 0;
        while (countOfWeek < 18 && !isWeek.equals("42"))  {
            isWeek = getWeek(scanner);
            if (!isWeek.equals("42")) {
                numOfWeek = getNumWeek(scanner);
                minOfWeek = getResults(scanner);
                results = makeResults(results, numOfWeek, minOfWeek);
                countOfWeek++;
            }
        }
        showResults(results);
        scanner.close();
    }
}

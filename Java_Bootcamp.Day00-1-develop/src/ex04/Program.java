package src.ex04;
import java.util.Scanner;

public class Program {
    private static final int MAX_COUNT = 65535;
    public static int sortMassive(int [] countArray, int count) {
        int indexToInsert = -1;
        boolean stop = true;

       for (int i = 0; i < 10 && stop; i++) {
           if (count > countArray[i]) {
               indexToInsert = i;
               stop = false;
           }
       }
       if (indexToInsert != -1) {
           for (int i = countArray.length - 1; i > indexToInsert; i--) {
               countArray[i] = countArray[i - 1];
           }
           countArray[indexToInsert] = count;
       }

        return indexToInsert;

    }
    public static void showResults(int[] countOfTen, int[] letters) {
        int [] temp = new int[10];
        temp[0] = 10;
        if (countOfTen[0] != 0) {
            for (int i = 1; i < 10 && countOfTen[i] != 0; i++) {
                temp[i] = countOfTen[i] * 10 / countOfTen[0];
            }
            for (int i = 11; i > 0; i--) {
                for (int j = 0; j < countOfTen.length && countOfTen[j] != 0; j++) {
                    if (temp[j] == i - 1) {
                        System.out.print(countOfTen[j] + "\t");
                    } else if (temp[j] >= i) {
                        System.out.print("#\t");
                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < letters.length && letters[i] != 0; i++) {
                System.out.print((char) letters[i] + "\t");
            }
        }
        System.out.println();

    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = true;
        int idx;
        String str = scanner.nextLine();
        int[] countChars = new int[MAX_COUNT];
        int[] firstTen = new int[10];
        int [] firstTenChar = new int[10];
        for (int i = 0; i < str.length() && stop; i++) {
            char c = str.charAt(i);
            countChars[c]++;
            if (countChars[c] > 999) {
                stop = false;
            }
        }
        if (stop) {
            for (int i = 0; i < countChars.length; i++) {
                idx = sortMassive(firstTen, countChars[i]);
                if (idx != -1) {
                    for (int j = 9; j > idx; j--) {
                        firstTenChar[j] = firstTenChar[j - 1];
                    }
                    firstTenChar[idx] = i;
                }
            }
            showResults(firstTen, firstTenChar);
        }
        scanner.close();
    }
}

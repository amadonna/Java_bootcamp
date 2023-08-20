public class Program {
    public Program () {
    }
    public static void main(String[] args) {
        int number = 444444;
        int res = 0;
        if (number >= 100000 && number < 1000000 ) {
            while (number % 10 != 0) {
                res += number % 10;
                number = (number - (number % 10)) / 10;
            }
            System.out.println(res);
        }
    }
}
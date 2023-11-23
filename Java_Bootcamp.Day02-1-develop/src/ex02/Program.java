package src.ex02;

public class Program {
    public static void main(String[] args) {
        if (args.length == 1) {
            String[] check = args[0].split("=");
            if (check.length < 2) {
                return;
            }
            if (!check[0].equals("--current-folder")) {
                return;
            }
            Terminal.getDirectory(check[1]);
        }
    }
}

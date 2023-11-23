package src.ex02;

public class GetSize {
    public static int get(String arg, String regex) {
        if (arg.startsWith(regex)) {
            String[] parts = arg.split("=");
            return Integer.parseInt(parts[parts.length - 1]);
        }
        return 0;
    }
}

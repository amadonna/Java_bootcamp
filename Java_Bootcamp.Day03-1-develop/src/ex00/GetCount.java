package src.ex00;

public class GetCount {
    public static int get(String arg) {
        if (arg.startsWith("--count=")) {
            String[] parts = arg.split("=");
            return Integer.parseInt(parts[parts.length - 1]);
        }
        return 0;
    }
}

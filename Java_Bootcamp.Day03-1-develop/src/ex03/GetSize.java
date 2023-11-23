package src.ex03;

public class GetSize {
    public static int get(String arg) {
        String[] parts = arg.split("=");
        return Integer.parseInt(parts[parts.length - 1]);
    }
}


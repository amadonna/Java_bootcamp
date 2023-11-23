package src.ex00;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadSignatures {
    public static Map<String, String> scanSignatures(String fileName) throws IOException {
        Map<String, String> signatures = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String filetype = parts[0];
                    String hex = parts[1].replaceAll(" ", "");
                    signatures.put(hex, filetype);
                }
            }
        }
        return signatures;
    }
}

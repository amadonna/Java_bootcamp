package edu.school21.chat.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadQueries {
    public static String[] getQueries(String fileName) {
        List<String> array = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder current = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && ! line.trim().startsWith("--")) {
                    current.append(line).append(" ");
                }
                if (line.trim().endsWith(";")) {
                    array.add(current.toString());
                    current.setLength(0);
                }
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return array.toArray(new String[0]);
    }
}

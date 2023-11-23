package src.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class ReadFile {
    public static Set<String> readFile(Set<String> dictionary, String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text;
            while ((text = reader.readLine()) != null) {
                String[] words = text.split("\\s+");
                dictionary.addAll(Arrays.asList(words));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}

package src.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class CalcWords {
    public static int[] calcWords(Set<String> set, String fileName) {
        int []vector = new int[set.size()];
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text;
            while ((text = reader.readLine()) != null) {
                String[] words = text.split("\\s+");
                for (String w : words) {
                    int i = 0;
                    for (Object o : set.toArray()) {
                        if (o.equals(w)) {
                            break;
                        }
                        i++;
                    }
                    vector[i]++;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return vector;
    }
}

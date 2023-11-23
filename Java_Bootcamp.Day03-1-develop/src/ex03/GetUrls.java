package src.ex03;

import java.io.*;
import java.util.*;

public class GetUrls {
    public static ArrayList<String> urls(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String url;
            while ((url = reader.readLine()) != null) {
                String[] words = url.split(" ");
                if (words.length == 2) {
                    list.add(words[1]);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

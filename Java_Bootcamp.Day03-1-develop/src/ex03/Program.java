package src.ex03;

import java.util.*;

public class Program {
    public static void main (String[] args) {
        ArrayList<String> list = GetUrls.urls("/Users/elodiawy/Java/Java_Bootcamp.Day03-1/src/ex03/text.txt");
        int countThreads = GetSize.get(args[0]);
        try {
            StartDownload.download(list, countThreads);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

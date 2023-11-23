package src.ex01;
import java.util.*;
public class Program {
    public static void main (String[] args) {
        TreeSet<String> set = new TreeSet<>();
        ReadFile.readFile(set, args[0]);
        ReadFile.readFile(set, args[1]);
        int[] vector1 = CalcWords.calcWords(set, args[0]);
        int[] vector2 = CalcWords.calcWords(set, args[1]);
        System.out.println("Similarity = " + Similarity.similarity(vector1, vector2));
    }
}

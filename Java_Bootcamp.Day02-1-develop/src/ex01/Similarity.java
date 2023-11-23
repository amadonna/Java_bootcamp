package src.ex01;

public class Similarity {
    public static double similarity(int [] vector1, int[] vector2) {
        int numerator = 0;
        int j = 0;
        for (int i : vector1) {
            numerator += i * vector2[j];
            j++;
        }
        double denominator = sqrt_vector(vector1) * sqrt_vector(vector2);
        return numerator / denominator;
    }
    private static double sqrt_vector(int [] vector) {
        int result = 0;
        for (int i : vector) {
            result += i * i;
        }
        return Math.sqrt(result);
    }

}

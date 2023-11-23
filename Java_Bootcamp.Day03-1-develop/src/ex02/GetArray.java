package src.ex02;

public class GetArray {
    public static int[] get(int size) {
        int[] array;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)Math.round((Math.random() * 2000) - 1000);
        }
        return array;
    }
}

package src.ex02;

public class SumThread extends Thread {
    private final int[] array;
    private final int start;
    private final int end;
    private int result;
    SumThread(int[] array, int begin, int end) {
        this.array = array;
        this.start = begin;
        this.end = end;
    }
    @Override
    public void run() {
        synchronized (array) {
            for (int i = start; i <= end; i++) {
                result += array[i];
            }
        }
    }
    public int getResult() { return result; }
    public int getStart() { return start; }
    public int getEnd() { return end; }

}

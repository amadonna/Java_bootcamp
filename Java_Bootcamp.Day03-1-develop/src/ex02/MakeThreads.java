package src.ex02;

public class MakeThreads {
    public static Thread[] make(int[] array, int size, int threads) {
        Thread[] thread = new Thread[threads];
        int sectionSize = size / threads;
        int start = 0;
        for (int i = 0; i < threads - 1; i++) {
            int end = start + sectionSize - 1;
            thread[i] = new SumThread(array, start, end);
            start = end + 1;
        }
        thread[threads - 1] = new SumThread(array, start, size - 1);
        return thread;
    }
}

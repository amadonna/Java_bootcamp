package src.ex02;

public class Program {
    public static void main (String[] args) {
        int size = 0;
        int threads = 0;
        if (args.length == 2) {
            size = GetSize.get(args[0], "--arraySize=");
            threads = GetSize.get(args[1], "--threadsCount=");
        }
        if (size > 2000000 || threads > size) {
            return;
        }
        int[] array = GetArray.get(size);
        for (int i : array) {
            System.out.print(i + " ");
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println("\nSum = " + sum);
        Thread[] thread = MakeThreads.make(array, size, threads);
        int sumThread = 0;
        for (int i = 0; i < threads; i++) {
            thread[i].start();
        }
        for (int i = 0; i < threads; i++) {
            try {
                thread[i].join();
                sumThread += ((SumThread) thread[i]).getResult();
                System.out.print("Thread " + i + ": from ");
                System.out.print(((SumThread) thread[i]).getStart() + " to ");
                System.out.print(((SumThread) thread[i]).getEnd() + " sum ");
                System.out.println("is " + ((SumThread) thread[i]).getResult());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + sumThread);
    }
}

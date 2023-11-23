package src.ex01;


public class Program {
    public static void main(String[] args) {
        int count = 0;
        Object object = new Object();
        if (args.length == 1) {
            count = GetCount.get(args[0]);
        }
        MyThread egg = new MyThread(object, "Egg", count);
        MyThread hen = new MyThread(object, "Hen", count);
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

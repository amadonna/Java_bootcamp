package src.ex00;

public class Program {
    public static void main(String[] args) {
        int count = 0;
        if (args.length == 1) {
            count = GetCount.get(args[0]);
        }
        MyThread egg = new MyThread("Egg", count);
        MyThread hen = new MyThread("Hen", count);
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}

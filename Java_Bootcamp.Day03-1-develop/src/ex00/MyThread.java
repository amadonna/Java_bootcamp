package src.ex00;

public class MyThread extends Thread {
    private Object object;
    private int count;

    public MyThread(Object object, int count) {
        this.count = count;
        this.object = object;
    }
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(object.toString());
        }
    }

}

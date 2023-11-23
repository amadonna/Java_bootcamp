package src.ex01;

public class MyThread extends Thread {
    private final Object lock;
    private final String eggHen;
    private final int count;

    public MyThread(Object lock, String eggHen, int count) {
        this.count = count;
        this.eggHen = eggHen;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                System.out.println(eggHen);
                lock.notify();
                try {
                    if (i < count - 1) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


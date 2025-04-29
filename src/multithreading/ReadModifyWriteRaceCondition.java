package multithreading;

public class ReadModifyWriteRaceCondition {
    public static void main(String[] args) {

        RWMTread runnable = new RWMTread();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count: " + runnable.getCount());
    }
}

class RWMTread implements Runnable {
    private int shared = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            shared++;
        }
    }

    public int getCount() {
        return shared;
    }
}

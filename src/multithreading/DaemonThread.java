package multithreading;

public class DaemonThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i + " " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "user thread");
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println(i + " " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "daemon thread");

        t1.start();
        t2.setDaemon(true);
        t2.start();
    }
}


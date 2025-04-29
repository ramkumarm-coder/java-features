package multithreading;

public class DeadLock {
    public static void main(String[] args) {

        String ram = "Ram";
        String ragu = "Ragu";

        Thread t1 = new Thread(() -> {
            synchronized (ragu) {
                System.out.println("Ram acquired Ragu");

                try {
                    System.out.println("Ram sleeping for 3 sec");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Ram woke up");

                synchronized (ram) {
                    System.out.println("Ram have an access");
                }
            }


        });

        Thread t2 = new Thread(() -> {
            synchronized (ram) {
                System.out.println("Ragu acquired Ram");

                try {
                    System.out.println("Ragu sleeping for 3 sec");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Ragu woke up");

                synchronized (ragu) {
                    System.out.println("Ragu have an access");
                }
            }


        });

        t1.start();
        t2.start();
    }
}

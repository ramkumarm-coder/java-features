package multithreading;

public class BankCheckAndAct implements Runnable {
    int balance = 100;

    public static void main(String[] args) {
        BankCheckAndAct bk = new BankCheckAndAct();
        Thread t1 = new Thread(bk, "Ramkumar");
        Thread t2 = new Thread(bk, "Ragu");

        t1.start();
        t2.start();
    }

    public void run() {
        System.out.println("Waiting to withdraw money by: " + Thread.currentThread().getName());
        if (balance >= 100) {
            System.out.println("Withdrawing money by: " + Thread.currentThread().getName());
            balance -= 50;
        } else {
            System.out.println("Unable to withdraw money by: " + Thread.currentThread().getName());
        }
        System.out.println("Balance Amount: " + balance + " (" + Thread.currentThread().getName() + ")");
    }

    public void runSolution() {
        System.out.println("Waiting to withdraw money by: " + Thread.currentThread().getName());
        synchronized (this) {
            if (balance >= 100) {
                System.out.println("Withdrawing money by: " + Thread.currentThread().getName());
                balance -= 50;
            } else {
                System.out.println("Unable to withdraw money by: " + Thread.currentThread().getName());
            }
            System.out.println("Balance Amount: " + balance + " (" + Thread.currentThread().getName() + ")");
        }
    }
}

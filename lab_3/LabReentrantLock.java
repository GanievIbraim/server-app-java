import java.util.concurrent.locks.ReentrantLock;

public class LabReentrantLock {
    private static int counter = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public static void decrement() {
        lock.lock();
        try {
            counter--;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java LabReentrantLock <n> <m>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        Thread[] incrementThreads = new Thread[n];
        Thread[] decrementThreads = new Thread[m];

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            incrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    increment();
                }
            });
            incrementThreads[i].start();
        }

        for (int i = 0; i < m; i++) {
            decrementThreads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    decrement();
                }
            });
            decrementThreads[i].start();
        }

        for (Thread thread : incrementThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread thread : decrementThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Final counter value: " + counter);
        System.out.println("Execution time: " + duration + " ms");
    }
}
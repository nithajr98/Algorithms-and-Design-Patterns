package concurrency;

import java.util.concurrent.locks.ReentrantLock;

class Increment {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }

    }

    public int getCount() {
        return this.count;
    }
}

public class RaceConditionsExample {
    public static void main(String[] args) throws InterruptedException {
        Increment eg = new Increment();
        for (int i = 0; i < 1000; i++) {
            Thread thread1 = new Thread(eg::increment);
            thread1.start();


        }
        System.out.println(eg.getCount());
    }
}

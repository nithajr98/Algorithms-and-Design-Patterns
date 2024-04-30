package concurrency;

class Counter {
    private static int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("new value after increment:" +getCount());
    }

    public synchronized void decrement() {
        count--;
        System.out.println("new value after decrement:" +getCount());
    }

    public synchronized int getCount() {
        return count;
    }
}

class Incrementer implements Runnable {
    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();

        }
    }
}

class Decrementer implements Runnable {
    private Counter counter;

    public Decrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.decrement();
        }
    }
}

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Creating two threads
        Thread incrementThread = new Thread(new Incrementer(counter));
        Thread decrementThread = new Thread(new Decrementer(counter));

        // Starting the threads
        incrementThread.start();
        decrementThread.start();

        // Waiting for threads to finish
        incrementThread.join();
        decrementThread.join();

        // Printing the final count
        System.out.println("Final count: " + counter.getCount());
    }
}

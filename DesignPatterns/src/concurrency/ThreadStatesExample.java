package concurrency;
public class ThreadStatesExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    // Simulate some task execution
                    Thread.sleep(5000);
                    // Wait for another thread to perform a task
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // NEW state
        System.out.println("Thread state after creation: " + thread.getState());

        // STARTED state
        thread.start();
        System.out.println("Thread state after starting: " + thread.getState());

        // Simulate some time for execution
        Thread.sleep(500);

        // RUNNABLE state
        System.out.println("Thread state during execution: " + thread.getState());

        // Acquire the lock and put the thread into a waiting state
        synchronized (lock) {
            // BLOCKED state (while acquiring the lock)
            System.out.println("Thread state after acquiring lock: " + thread.getState());
        }

        // WAITING state (after releasing the lock and waiting)
        System.out.println("Thread state after releasing lock and waiting: " + thread.getState());

        // Notify to wake up the waiting thread
        synchronized (lock) {
            lock.notify();
        }

        // Joining to wait for the thread to terminate
        thread.join();

        // TERMINATED state
        System.out.println("Thread state after termination: " + thread.getState());
    }
}

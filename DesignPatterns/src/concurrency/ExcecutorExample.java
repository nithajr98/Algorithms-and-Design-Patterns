package concurrency;

import java.util.concurrent.*;

public class ExcecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> callableTask = ()->{
            Thread.sleep(1000);
            return 42;

        };

        Future<Integer> futureResult = executorService.submit(callableTask);

        Integer result = futureResult.get();
        System.out.println(result);
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + finalI));
        }
        executorService.shutdown();
    }
}

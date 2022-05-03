package random;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (obj) {
                Instant start = Instant.now();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted! Shutting down gracefully" + Thread.currentThread().getName());
                }
                System.out.println("Exiting: " + Duration.between(Instant.now(), start).toMillis());
            }
        });
//        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                Instant start = Instant.now();
                Thread.sleep(Duration.ofSeconds(4).toMillis());
                System.out.println("Interrupting thread 1: " + Duration.between(Instant.now(), start).toMillis());
                thread1.interrupt();
            } catch (InterruptedException e) {
                System.out.println("Interrupted! Shutting down gracefully" + Thread.currentThread().getName());
            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                Instant start = Instant.now();
                Thread.sleep(Duration.ofSeconds(2).toMillis());
                System.out.println("Finished thread 3 task");
                synchronized (obj) {
                    obj.notify();
                }
//                thread1.join();
                System.out.println("Waiting for thread 2 to complete: " + Duration.between(Instant.now(), start).toMillis());
            } catch (InterruptedException e) {
                System.out.println("Interrupted! Shutting down gracefully" + Thread.currentThread().getName());
            }
        });
        thread3.start();

        CompletableFuture<Integer> future = new CompletableFuture<>();
        future.complete(intRet(4));
        future.thenAccept(System.out::println);

        future.complete(intRet(6));
        future.thenAccept(System.out::println);


    }

    private static int intRet(int val) {
        try {
            Thread.sleep(Duration.ofSeconds(4).toMillis());
            return val;
        } catch (InterruptedException e) {
            System.out.println("Interrupted! Shutting down gracefully" + Thread.currentThread().getName());
        }
        return 0;
    }
}

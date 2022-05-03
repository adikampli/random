package random;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class Future {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = future1();
        CompletableFuture<String> future2 = future2();
        CompletableFuture<String> future3 = future3();

        Instant start = Instant.now();

        future1.thenCombine(future2, (s1, s2) -> s1 + s2)
                .thenCombine(future3, (s1, s2) -> s1 + s2)
                .thenAccept(System.out::println);

        future1.thenApply(s -> "Completed " + s)
                .thenAccept(System.out::println);

        future1.thenCompose(Future::future4)
                .thenAccept(System.out::println);

        CompletableFuture.allOf(future1, future2, future3).join();

        delay(4);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    private static CompletableFuture<String> future4(String s) {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return "future4" + s;
        });
    }

    private static CompletableFuture<String> future3() {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return "future3";
        });
    }

    private static CompletableFuture<String> future2() {
        return CompletableFuture.supplyAsync(() -> {
            delay(2);
            return "future2";
        });
    }

    private static CompletableFuture<String> future1() {
        return CompletableFuture.supplyAsync(() -> {
            delay(1);
            return "future1";
        });
    }

    private static void delay(int i) {
        try {
            Thread.sleep(Duration.ofSeconds(i).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

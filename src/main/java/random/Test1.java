package random;


import java.util.concurrent.*;
import java.util.concurrent.Future;

class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//        CustomLL ll = new CustomLL();
//        ll.add(2);
//        ll.add(1);
//        ll.add(9);
//        ll.add(11);
//        ll.add(6);
//        ll.add(5);
//        System.out.println(ll);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        Future<String> f = CompletableFuture.supplyAsync(() -> "test", executorService);
        String s = f.get(1, TimeUnit.SECONDS);
        System.out.println(s);
    }
}
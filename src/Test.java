import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Test implements Runnable {

    static Integer counter = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());

        t1.start();
        t2.start();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("intasdsa")));
            outputStream.writeObject(new Employee("asdasd", 22));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.newBufferedReader(Paths.get(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        synchronized (lock) {
            while(counter < 10) {
                if(counter % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + counter);
                    counter++;
                    try {
                        lock.wait();
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {

                    System.out.println(Thread.currentThread().getName() + counter);
                    counter++;
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }


   /*
   Concurrent HashMap implementation
   public static void main(String[] args) {
        long start = System.nanoTime();
        Map<String, String> map = new ConcurrentHashMap<>();

        CompletableFuture<Map<String, String>> future1 = CompletableFuture.supplyAsync(() -> updateMap(map));
        CompletableFuture<Map<String, String>> future2 = CompletableFuture.supplyAsync(() -> updateMap(map));
        CompletableFuture<Map<String, String>> future3 = CompletableFuture.supplyAsync(() -> updateMap(map));
        CompletableFuture<Map<String, String>> future4 = CompletableFuture.supplyAsync(() -> updateMap(map));

        future1.join();
        future2.join();
        future3.join();
        future4.join();

        map.keySet().forEach(System.out::println);
        long end = System.nanoTime();
        System.out.println((end - start) * Math.pow(10, 8));
    }

    private static Map<String, String> updateMap(Map<String, String> map) {
        for (int i = 0; i < 100; i++) {
            map.put(Thread.currentThread().getName() + "_" + i, Thread.currentThread().getName() + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return map;
    }*/
}

package random;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Increment increment = new Increment(counter);
        Decrement decrement = new Decrement(counter);

        increment.start();
        decrement.start();

        increment.join();
        decrement.join();

        System.out.println(counter.getCount());

        Semaphore full = new Semaphore(2);

        Thread thread1 = new Thread(() -> {
            try {
                full.acquire();
                Thread.sleep(5000);
                full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Semaphore acquired" + Thread.currentThread().getName());

        });

        Thread thread2 = new Thread(() -> {
            try {
                full.acquire();
                Thread.sleep(5000);
                full.release();
                System.out.println("Semaphore acquired" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                full.acquire();
                Thread.sleep(5000);
                full.release();
                System.out.println("Semaphore acquired" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class Increment extends Thread {
    Counter count;

    Increment(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count.increment();
        }
    }
}

class Decrement extends Thread {
    Counter count;

    Decrement(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count.decrement();
        }
    }
}

class Counter {
    int count = 0;

    Lock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    void decrement() {
        lock.lock();
        count--;
        lock.unlock();
    }

    int getCount() {
        return count;
    }
}


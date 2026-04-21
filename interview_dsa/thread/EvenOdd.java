package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {
    public static void main(String[] args) throws InterruptedException {
        //Used Count Down Latch to make sure the odd thread start first and
        //Then even thread
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger num = new AtomicInteger(0);
        Object lock = new Object();
        Even even = new Even(num,lock,latch);
        Odd odd = new Odd(num,lock,latch);

        even.start();
        odd.start();
        latch.await();
    }
}


class Even extends Thread{
    private AtomicInteger num;
    private final Object lock;
    CountDownLatch latch;
    Even(AtomicInteger num,Object lock,CountDownLatch latch){
        this.num = num;
        this.lock = lock;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Even ..");
        synchronized (lock){
            System.out.println("1Even ..");
            // A spurious wakeup happens when a thread wakes up from waiting on a condition variable that's been signaled,
            // only to discover that the condition it was waiting for isn't satisfied. It's called spurious because the
            // thread has seemingly been awakened for no reason. But spurious wakeups don't happen for no reason,
            // they usually happen because in between the time when the condition variable was signaled and when
            // the waiting thread finally ran, another thread ran and changed the condition. There was a race condition
            // between the threads, with the typical result that sometimes, the thread waking up
            // on the condition variable runs first, winning the race, and sometimes it runs second, losing the race.
            while (true){
                if(num.get()%2!=0){
                    try {
                        System.out.println("waiting ..");
                        latch.countDown();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Even :"+num.intValue());
                    //Atomically increments the current value by 1 and returns new value after the increment
                    num.incrementAndGet();
                    lock.notify();
                }
            }
        }
    }
}

class Odd extends Thread{
    AtomicInteger num;
    final Object lock;
    CountDownLatch latch;

    Odd(AtomicInteger num,Object lock,CountDownLatch latch) {
        this.num = num;
        this.lock = lock;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("odd ..");
        synchronized (lock){
            System.out.println("acquired lock odd");
            while (true){
                if(num.get()%2==0){
                    try {
                        System.out.println("waiting ..odd");
                        latch.countDown();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Odd :"+num.intValue());
                    num.incrementAndGet();
                    lock.notify();
                }
            }
        }
    }
}
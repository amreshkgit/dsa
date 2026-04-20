package thread;

import java.util.concurrent.Semaphore;

/**
 * Restrict/Manage the use of limited resources use the semaphore
 *
 * Consider an ATM cubicle with 4 ATMs, Semaphore can make sure only 4 people can access simultaneously.
 * Semaphores – Restrict the number of threads that can access a resource. Example, limit max 10 connections to access a file simultaneously.
 * Mutex – Only one thread to access a resource at once. Example, when a client is accessing a file, no one else
 * should have access the same file at the same time.
 *
 * Mutex is the Semaphore with an access count of 1. Consider a situation of using lockers in the bank.
 * Usually the rule is that only one person is allowed to enter the locker room.
 *
 *  The Mutex is a locking mechanism that makes sure only one thread can acquire the Mutex at a time and enter the critical section.
 */
public class SemaphoreTest {
    // max 4 people
    //static Semaphore semaphore = new Semaphore(4,true); -- fairness guarantee for thread waiting the longest
    static Semaphore semaphore = new Semaphore(4);

    // max 1 people when
    static Semaphore mutex = new Semaphore(1);

    static class MyATMThread extends Thread {

        String name = "";

        MyATMThread(String name) {
            this.name = name;
        }

        public void run() {

            try {


                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: " + semaphore.availablePermits());

                semaphore.acquire();
                //semaphore.acquireUninterruptibly();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i + ", available Semaphore permits : " + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "+ semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());

        MyATMThread t1 = new MyATMThread("A");
        t1.start();

        MyATMThread t2 = new MyATMThread("B");
        t2.start();

        MyATMThread t3 = new MyATMThread("C");
        t3.start();

        MyATMThread t4 = new MyATMThread("D");
        t4.start();

        MyATMThread t5 = new MyATMThread("E");
        t5.start();

        MyATMThread t6 = new MyATMThread("F");
        t6.start();

    }
}

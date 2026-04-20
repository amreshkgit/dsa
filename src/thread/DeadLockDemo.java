package thread;

public class DeadLockDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t12 = new Thread(new Mythread1(o1,o2),"T1");
        Thread t23 = new Thread(new Mythread2(o1,o2),"T2");
        t12.start();
        t23.start();
    }
}

class Mythread1 implements Runnable{
    Object lock1;
    Object lock2;

    public Mythread1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run()  {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() +"locked on resource1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() +"locked on resource2");
            }
        }
    }

}

class Mythread2 implements Runnable{
    Object lock1;
    Object lock2;

    public Mythread2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run()  {
        synchronized (lock2){
            System.out.println(Thread.currentThread().getName() +"locked resource2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName() +"locked resource1");
            }
        }
    }

}

/*
Thread-1 acquires lock on String.class and then calls sleep() method which gives Thread-2
the chance to execute immediately after Thread-1 has acquired lock on String.class and
Thread-2 acquires lock on Object.class then calls sleep() method and now it waits for Thread-1 to release lock on String.class.
Conclusion:
Now, Thread-1 is waiting for Thread-2 to release lock on Object.class and Thread-2 is waiting
for Thread-1 to release lock on String.class and deadlock is formed.

Code called by Thread-1
 public void run() {
           synchronized (String.class) {
                    Thread.sleep(100);
                  synchronized (Object.class) {
                  }
           }
 }

Code called by Thread-2
    public void run() {
           synchronized (Object.class) {
                    Thread.sleep(100);
                  synchronized (String.class) {
                  }
           }
 }
 */
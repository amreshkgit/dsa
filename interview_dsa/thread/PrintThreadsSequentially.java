package thread;

public class PrintThreadsSequentially {
    public static void main(String[] args) {
        Object lock=new Object();
        PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1,lock);
        PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2,lock);
        PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0,lock);

        Thread t1 = new Thread(runnable1,"T1");
        Thread t2 = new Thread(runnable2,"T2");
        Thread t3 = new Thread(runnable3,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintSequenceRunnable implements Runnable{

    int PRINT_NUMBERS_UPTO=10;
    static int number=1;
    int remainder;
    final Object lock;

    PrintSequenceRunnable(int remainder,Object lock)
    {
        this.remainder = remainder;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
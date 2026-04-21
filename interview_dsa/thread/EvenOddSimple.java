package thread;

public class EvenOddSimple implements Runnable {

    final Object object;
    static int i = 1;

    public EvenOddSimple(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (i <= 10) {
            if (i % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Runnable t1 = new EvenOddSimple(object);
        Runnable t2 = new EvenOddSimple(object);
        new Thread(t1, "even").start();
        new Thread(t2, "odd").start();
    }
}

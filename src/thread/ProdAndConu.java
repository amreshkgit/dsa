package thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProdAndConu {
    public static void main(String[] args) {
        int i =0;
        AtomicBoolean available = new AtomicBoolean(true);
        Object lock = new Object();

        Prod p = new Prod(i,lock,available);
        Consu c = new Consu(i,lock,available);
        p.start();
        c.start();
    }
}

class Prod extends Thread{
    volatile int i;
    Object lock;
    AtomicBoolean available;

    public Prod(int i,Object lock,AtomicBoolean available) {
        this.i = i;
        this.lock = lock;
        this.available = available;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("in Pord ==" + available.get());
            for (int i = 1; i < 5; i++){
                while (available.get()) {
                    System.out.println("Produces : " + i);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
            available.set(false);
            System.out.println("going to notify()....1");
            lock.notify();
        }
    }
}


class Consu extends Thread{
    volatile int i;
    final Object lock;
    AtomicBoolean available;

    public Consu(int i,Object lock,AtomicBoolean available) {
        this.i = i;
        this.lock = lock;
        this.available = available;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("in Consu ==" + available.get());
            for (int i = 1; i < 5; i++){
            while (!available.get()) {
                System.out.println("consumes : " + i);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            available.set(false);
            System.out.println("going to notify()....2");
            lock.notify();
        }
       }
    }
}

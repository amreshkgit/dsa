package thread;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Shared c = new Shared();
        Producer p1 = new Producer(c);
        Consumer c1 = new Consumer(c);
        p1.start();
        c1.start();
    }
}

class Producer extends Thread {

    private Shared shared;

    public Producer(Shared shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            shared.put(i);
            System.out.println("Produced value: " + i);
            try {
               //sleep((int) (Math.random() * 100));
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
class Consumer extends Thread {

    private Shared shared;
    public Consumer(Shared shared)
    {
        this.shared = shared;
    }
    @Override
    public void run()
    {
        int value;
        for (int i = 1; i < 10; i++)
        {
            value = shared.get();
            System.out.println("Consumed value got: " + value);
        }
    }
}


class Shared {
    private int value;
    private boolean available = false;

    public synchronized int get() {
        System.out.println("Available in get "+available);
        while (!available) {
            try {
                System.out.println("in try block in get..waiting");
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        available = false;
        //notify Producer that value has been retrieved
        notify();
        return value;
    }

    public synchronized void put(int val) {
        System.out.println("Available in put "+available +"value : "+value);
        while (available) {
            try {
                System.out.println("in try block put ...waiting");
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        value = val;
        //notify Consumer that value has been set
        available = true;
        notify();
    }
}
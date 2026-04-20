package interviewProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer pattern is a design pattern in which an object, named the subject,
 * maintains a list of its dependents, called observers,
 * and notifies them automatically of any state changes, usually by calling one of their methods
 */
public class ObserverDesignPattern {
    public static void main(String[] args) {
        Channel telusko = new Channel();
        Subscriber s1 = new Subscriber("Amresh");
        Subscriber s2 = new Subscriber("Ankit");
        Subscriber s3 = new Subscriber("Akash");
        Subscriber s4 = new Subscriber("Amit");

        telusko.subscribe(s1);
        telusko.subscribe(s2);
        telusko.subscribe(s3);
        telusko.subscribe(s4);

        telusko.unSubscribe(s3);

        s1.subscribeChannel(telusko);
        s2.subscribeChannel(telusko);
        s3.subscribeChannel(telusko);
        s4.subscribeChannel(telusko);

        telusko.upload("How to learn programming??");

    }
}


class Subscriber{

    private String name;

    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(){
        System.out.println("Hey " +name+" Java Techie uploaded new video");
    }

    public void subscribeChannel(Channel channel){
        this.channel = channel;
    }
}

class Channel{

    List<Subscriber> subscribers = new ArrayList<>();

    private String title;

    public void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscriber(){
        for(Subscriber subscriber : subscribers){
            subscriber.update();
        }
    }

    public void upload(String title){
        this.title = title;
        notifySubscriber();
    }
}

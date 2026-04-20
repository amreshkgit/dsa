package algorithms.queue;

import java.util.Stack;

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(8);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}

class QueueUsingStack{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int val){

        s1.push(val);
    }

    public int dequeue(){
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public boolean empty(){
        if(s1.empty() && s2.empty())
            return true;
        else
            return false;
    }

    public int size(){
        return s1.size() + s2.size();
    }
}

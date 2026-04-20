package algorithms.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUingTwoQueue {
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        }
}

class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        q2.add(val);
        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public void pop() {
        // if no elements are there in q1
        if (q1.isEmpty())
            return;
        q1.remove();
    }

    public int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

}


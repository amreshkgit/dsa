package algorithms.stack;

import java.util.Stack;

public class GetMinimumElementFormStack {
    static Stack<Integer> mainStack;
    static Stack<Integer> supportingStack;
    public static void main(String[] args) {
        mainStack = new Stack<>();
        supportingStack = new Stack<>();
        push(50);
        push(40);
        push(35);
        push(55);
        push(37);
        push(20);
        pop();
        pop();
        push(60);
    }
    static void push(int value) {
        mainStack.add(value);
        if (supportingStack.isEmpty()) {
            supportingStack.add(value);
        } else if (mainStack.peek() < supportingStack.peek()) {
            supportingStack.push(mainStack.peek());
        }
    }
    static void pop(){
        if(mainStack.pop().equals(supportingStack.peek())){
            System.out.println(supportingStack.pop());
        }
        //System.out.println(supportingStack.toString());
    }
}


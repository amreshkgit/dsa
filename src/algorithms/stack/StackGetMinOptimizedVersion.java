package algorithms.stack;

import java.util.Stack;

public class StackGetMinOptimizedVersion {
    Stack<Integer> stack;
    Integer min;

    public StackGetMinOptimizedVersion(){
        stack = new Stack<>();
    }
    public static void main(String[] args) {
        StackGetMinOptimizedVersion o = new StackGetMinOptimizedVersion();
        o.push(3);
        o.push(5);
        o.getMin();
        o.push(2);
        o.push(1);
        o.getMin();
        //o.pop();
       // o.getMin();
       // o.pop();
       // o.pop();
    }

    public void push(int x){
        if(stack.isEmpty()){
            min = x;
            stack.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        } if(x < min){ // change < to > to get Max element from
            stack.push(2*x-min);
            min = x;
        }else{
            stack.push(x);
        }
        System.out.println("Number Inserted: " + x);
    }

    public void pop(){
        if(stack.isEmpty()){
            System.out.println("stack is underflow");
            return;
        }
         int t = stack.peek();
        stack.pop();
        if(t < min){
            stack.push(2*min-t); // while getting back to next minimum element using this formula 2*min-t
        }else{
            System.out.println(t);
        }
    }

    void getMin()
    {
        if (stack.empty())
            System.out.println("stack is empty");

            // variable minEle stores the minimum element
            // in the stack.
        else
            System.out.println("Minimum Element in the stack is: "+min);
    }
}

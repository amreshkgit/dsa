package algorithms.stack;

public class StackMain {
    public static void main(String[] args) {
      Stack stack = new Stack(5);
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      stack.print();
      System.out.print("\nPopped from stack : ");
      stack.pop();
    }
}

class Stack{
  int top = -1;
  int size;
  int [] stack;

  Stack(int size){
      this.size = size;
      stack = new int[size];
  }

  public boolean isEmpty(){
      if(top < 0){
          System.out.println("Stack is empty");
          return true;
      }
      return  false;
  }

  public void push(int data){
           if(top < size) {
               stack[++top] = data;
           }else
           {
               System.out.println("Stack is overflow");
           }
  }
  public void pop(){
      if(!isEmpty()){
          System.out.print(stack[top]);
          top--;
      }else
      {
          System.out.println("Stack is underflow");
      }
  }

  public  void print(){
      for(int i : stack){
          System.out.print(i+"\t");
      }
  }
 }

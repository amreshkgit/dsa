package linkedList;

public class FactorialOfLargeNumber {
    static class Node {
        int data;
        Node prev;

        Node(int data){
            this.data = data;
            this.prev = null;
        }
    }
    public static void main(String[] args) {
        int num = 10;
        Node tail = new Node(1);// create a new node and initialize with one
        for(int i = 2;i <= num;i++){
            findFact(tail,i);
        }
        print(tail);
    }

    public static void findFact(Node tail, int n){
       Node temp = tail, preNode = tail;
       int carry = 0;
       while (temp != null){
           int data = temp.data * n + carry;
           temp.data = data % 10;// Kyun ki hame digit rakhni hai isliye mode kiya
           carry = data / 10;
           preNode = temp;
           temp = temp.prev;
       }
       //Abhi socho carry 120 aa jaye to hame 120 ka nayi linkedlist banani hai example 1-->2-->0
       while (carry!=0){
           preNode.prev = new Node(carry %10);
           carry /= 10;
           preNode = preNode.prev;
       }
    }

    public static void print(Node tail){
        if(tail == null) return;
        print(tail.prev);
        System.out.print(tail.data);
    }
}

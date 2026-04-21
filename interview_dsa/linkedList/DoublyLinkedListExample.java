package linkedList;

public class DoublyLinkedListExample {
    public static void main(String[] args) {
     DoublyLinkedList list = new DoublyLinkedList();
     list.insertAtHead(10);
     list.insertAtHead(20);
     list.insertAtHead(30);
     list.print();
    }
}

class Node1{
    int data;
    Node1 next;
    Node1 prev;

    Node1(int data){
        this.data = data;
    }
}

class DoublyLinkedList{
 Node1 head;

 public void insertAtHead(int data){
     Node1 newNode = new Node1(data);
     if(head == null){
         head = newNode;
         return;
     }
     head.prev = newNode;
     newNode.next = head;
     head = newNode;
 }
 public void print(){
     Node1 node = head;
     if(node == null) return;
     while (node !=null){
         System.out.print(node.data + " ");
            node = node.next;
     }
 }
}

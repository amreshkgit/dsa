package linkedList;

public class DeleteAllTheOccurence {

    static Node2 head;
    /* Node Class */
    class Node2
    {
        int data;
        Node2 next;
        // Constructor to create a new node
        Node2(int d) {data = d; next = null; }
        Node2(){}
    }

    public static void main(String[] args) {
        DeleteAllTheOccurence list = new DeleteAllTheOccurence();
        list.addAtFront(10);
        list.addAtFront(40);
        list.addAtFront(30);
        list.addAtFront(20);
        list.addAtFront(10);
        list.addAtFront(10);
        System.out.println("Given List");
        list.printList();
        System.out.println("Removing after duplicate");
        head = list.removeOccurence(10);
        list.printList();

    }

    public void addAtFront(int data)
    {
        /* 1 & 2: Allocate the Node &  Put in the data*/
        Node2 node = new Node2(data);
        /* 3. Make next of new Node as head */
        node.next = head;
        /* 4. Move the head to point to new Node */
        head = node;
    }
    public void printList(){
        Node2 tmp = head;


        while(tmp!=null){
            System.out.print(tmp.data + "-->");
            tmp = tmp.next;
        }
        System.out.print("NULL" + "\n");
    }

    public Node2 removeOccurence(int i){
        Node2 current = head;
         Node2 tmp = head;
        while (current.next != null) {
            if (current.next.data == i) {
                current.next=current.next.next;
            } else {
                current = current.next;
            }
        }
        if(tmp.data == i) {
            return tmp.next;
        }

        return head;
    }
}



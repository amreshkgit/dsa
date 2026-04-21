package linkedList;

public class LinkedList {

    Node head; //head of list

    /* Node Class */
    class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtFront(12);
        list.addAtFront(10);
        list.addAtFront(22);
        list.addAtFront(34);
        list.addAtFront(46);
       // list.addAtEnd(54);
       // list.addAtEnd(78);
        System.out.println("-------Linked List------");
        list.printList();
       // System.out.println("Size of LinkedList :: "+list.size());
       /* System.out.println("------ Linked List after deleting the last K Node -----");
        list.deleteLastKNode(2);
        list.printList(); */
       // System.out.println("--- After revering the LinkedList ---");
       // list.recursivelyReverseTheList(head);
       // list.printList();
        //list.reverseIteratively();
        //list.printList();
        //list.head = list.reversePairWise(list.head,2);
        //list.printList();
        int n = list.getNthFromLast(list.head,2);
        System.out.println("n: "+n);
    }

    public void addAtFront(int data)
    {
        /* 1 & 2: Allocate the Node &  Put in the data*/
        Node new_node = new Node(data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public Node addAtFront_1(int data,Node head)
    {
        /* 1 & 2: Allocate the Node &  Put in the data*/
        Node new_node = new Node(data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
        return head;
    }

    public void addAtEnd(int data)
    {
        Node new_node = new Node(data);
        Node tmp = head;
        while(tmp.next!=null){
            if(tmp.next==null) {
                tmp.next = new_node;
                new_node.next =null;
            }
            tmp = tmp.next;
        }
    }

    public void printList(){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(tmp.data+"-->");
            tmp = tmp.next;
        }
        System.out.print("NULL"+"\n");
    }

    public void printList_1(Node head){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(tmp.data+"-->");
            tmp = tmp.next;
        }
        System.out.print("NULL"+"\n");
    }

    public void deleteLastKNode(int lastKNode){
        int count =1;
        Node current = head;
        int remainingNode = size()-lastKNode;
        while (count <= remainingNode){
            System.out.print(current.data+" ");
            current = current.next;
            count++;
            if(count == remainingNode){
                current.next = null;
            }
        }

    }

    public int size(){
        int count = 0;
        Node current = head;
        while(current!=null){
            count ++;
            current = current.next;
        }
        return count;
    }

    public void recursivelyReverseTheList(Node p) {
        if (p.next == null) {
            head = p;
            return;
        }
        recursivelyReverseTheList(p.next);
        //p.next.next =p;  we can add this single instead of below three line of code
        Node q = p.next;
        q.next = p;
        p.next = null;
     }

     public void reverseIteratively(){
        Node current = head;
        Node prev = null;
        while(current !=null){//will iterate till current become null
           Node next = current.next; //Store next pointer to node next variable
           current.next = prev; //now point perv node to current node
           prev = current; //assign current address to prev and at the end previous will store the last node address
           current = next; //
        }
        head = prev; // at the end we need to adjust the head to previous which is point to our last node
     }

    public Node reversePairWise(Node head, int k){
        if(head == null)return null;
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while( count < k && current != null){//will iterate till current become null
            next = current.next; //Store next pointer to node next variable
            current.next = prev; //now point perv node to current node
            prev = current; //assign current address to prev and at the end previous will store the last node address
            current = next; //
            count++;
        }
        if(next != null)
            head.next = reversePairWise(next,k);
        return prev; // at the end we need to adjust the head to previous which is point to our last node
    }

    int getNthFromLast(Node head, int n)
    {
        Node cur = head;
        int data = 0;
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;
        }

        if(n > size) return -1;
        int k = 0;
        cur = head;
        while(cur !=null){
            k++;
            if(k == size - n +1)
                data = cur.data;
            cur = cur.next;
        }
        return data;
    }

}



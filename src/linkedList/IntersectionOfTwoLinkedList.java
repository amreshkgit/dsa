package linkedList;

/**
 *  pahle dono list ka length nikalo
 */
public class IntersectionOfTwoLinkedList {
    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static void main(String[] args) {
        IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);
        System.out.println(list.intersectionPoint(head1,head2));
    }

    public int intersectionPoint(Node head1, Node head2){
        Node ptr1 = head1;
        Node ptr2 = head2;
        int c1=0,c2=0;
        //int diff;
        //To get length of 1st list
        while (ptr1 != null){
            c1++;
            ptr1 = ptr1.next;
        }
        //To get length of 2nd list
        while (ptr2 != null){
            c2++;
            ptr2 = ptr2.next;
        }
        ptr1 = head1;
        ptr2 = head2;

        //To get diff of length of two linked list
        int diff = Math.abs(c1-c2);

        //To make the list at the same level move the pointer until it reaches the diff length
        if(c1 > c2){
            for (int i =0 ; i<diff;i++){
                ptr1 = ptr1.next;
            }
        }else{
            for (int i =0 ; i<diff;i++){
                ptr2 = ptr2.next;
            }
        }

        //To check until both are not pointing to the same node
        while (ptr1.data != ptr2.data){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1.data;
    }
}


package linkedList;

public class PairwiseSwapNodesOfLinkedList {
    public static void main(String[] args) {
        LinkedList node = new LinkedList();
        LinkedList.Node n1 = node.addAtFront_1(7,null);
        LinkedList.Node n2 = node.addAtFront_1(4,n1);
        LinkedList.Node n3 = node.addAtFront_1(3,n2);
        LinkedList.Node n4 = node.addAtFront_1(2,n3);
        LinkedList.Node n5 = node.addAtFront_1(5,n4);

        System.out.println("Before");
        node.printList_1(n5);
        System.out.println("After");
       // LinkedList.Node n = reverseInGroup(n5,2);
        LinkedList.Node head = reverseInGroup_1(n5);
        node.printList_1(head);
    }

    public static LinkedList.Node reverseInGroup(LinkedList.Node head,int k){
        LinkedList.Node next,prev;
        next = prev = null;
        LinkedList.Node node = head;

        int i =0;

        while(node !=null && i < k){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            i++;
        }
        if(next !=null)
            head.next = reverseInGroup(next,k);
        return prev;
    }

    public static LinkedList.Node reverseInGroup_1(LinkedList.Node start){
        LinkedList.Node p = start;
        LinkedList.Node new_start = p.next;
        LinkedList.Node q,temp;
        while (true){
            q = p.next;
            temp = q.next;
            q.next = p;
            //temp ==null is for even number of node
            // temp.next == null for when odd number of node
            if(temp == null || temp.next == null){
                p.next = temp;
                break;
            }
            p.next= temp.next;
            p = temp;
        }
        return new_start;

    }
}

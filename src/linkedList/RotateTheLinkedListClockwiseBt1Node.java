package linkedList;

public class RotateTheLinkedListClockwiseBt1Node {
    public static void main(String[] args) {
        LinkedList node = new LinkedList();

        LinkedList.Node n1 = node.addAtFront_1(18,null);
        LinkedList.Node n2 = node.addAtFront_1(8,n1);
        LinkedList.Node n3 = node.addAtFront_1(37,n2);
        LinkedList.Node n4 = node.addAtFront_1(99,n3);
        LinkedList.Node n5 = node.addAtFront_1(12,n4);

        System.out.println("Before");
        node.printList_1(n5);
        System.out.println("After");
        LinkedList.Node head = rotateClockWiseByNode(n5,1);
        node.printList_1(head);
    }

    public static LinkedList.Node rotateClockWiseByNode(LinkedList.Node head,int k){
        //if node is null or k is less than zero then return that node
        if(head ==null || k <0)
            return head;


        LinkedList.Node cur = head;
        LinkedList.Node prev = null;
        while (cur != null){
            if(cur.next ==null){
                cur.next = head;
                head = cur;
                prev.next = null;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}

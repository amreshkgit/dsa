package linkedList;

public class RemoveLargestElement {
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
        LinkedList.Node n = removeLargestElement(n5);
        node.printList_1(n);

    }

    public static LinkedList.Node removeLargestElement(LinkedList.Node head){
        LinkedList.Node prev =null;
        LinkedList.Node cur = head;
        int max = head.data;

        while(cur!=null){
            if(cur.data > max){
                max = cur.data;
            }
            cur = cur.next;
        }

        cur = head;

        while(cur!=null){
            if(cur.data == max && cur.next!=null){
               LinkedList.Node temp = cur.next;
                prev.next = temp;
                break;
            }if(cur.data == max && cur.next==null) {
                prev.next = null;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        return head;
    }//method end
}//main class end

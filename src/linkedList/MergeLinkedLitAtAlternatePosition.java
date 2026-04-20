package linkedList;

public class MergeLinkedLitAtAlternatePosition {

    Node3 head;

    static class Node3{
        int data;
        Node3 next;
        Node3(int data){this.data=data;next=null;}
    }

    public static void main(String[] args) {
        MergeLinkedLitAtAlternatePosition list1 = new MergeLinkedLitAtAlternatePosition();
        list1.push(11);
        list1.push(13);
        list1.push(17);
        list1.push(7);
        list1.push(5);
        System.out.println("Given first List");
        list1.print();
        MergeLinkedLitAtAlternatePosition list2 = new MergeLinkedLitAtAlternatePosition();
        list2.push(6);
        list2.push(4);
        list2.push(2);
        list2.push(10);
        list2.push(12);
        System.out.println("Given second List");
        list2.print();
        list1.addListToAlternatePosition(list2);
        System.out.println("Modified first linked list:");
        list1.print();
        System.out.println("Modified second linked list:");
        list2.print();
    }

    public void push(int data){
        Node3 node = new Node3(data);
        node.next = head;
        head = node;
    }

    public void print(){
        Node3 current = head;
        while (current!=null){
            System.out.print(current.data+" ");
            current =current.next;
        }
        System.out.println(" ");
    }

    public void addListToAlternatePosition(MergeLinkedLitAtAlternatePosition q){
        Node3 p_curr = head, q_curr = q.head;
        Node3 p_next, q_next;

        // While there are available positions in p;
        while (p_curr != null && q_curr != null) {

            // Save next pointers
            p_next = p_curr.next;
            q_next = q_curr.next;

            // make q_curr as next of p_curr
            q_curr.next = p_next; // change next pointer of q_curr
            p_curr.next = q_curr; // change next pointer of p_curr

            // update current pointers for next iteration
            p_curr = p_next;
            q_curr = q_next;
        }
        q.head = q_curr;
    }
}


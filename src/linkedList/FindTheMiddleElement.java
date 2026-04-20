package linkedList;

public class FindTheMiddleElement {

    Node2 head;

    class Node2{
        int data;
        Node2 next;
        Node2(int data){this.data=data;next=null;}
    }

    public static void main(String[] args) {
        FindTheMiddleElement list = new FindTheMiddleElement();
        list.addAtFront(6);
        list.addAtFront(5);
        list.addAtFront(4);
        list.addAtFront(3);
        list.addAtFront(2);
        list.addAtFront(1);
        System.out.println("Given List");
        list.printList();
        System.out.println("Removing after duplicate");
        list.findTheMiddleElement(6);
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
            System.out.print(tmp.data+"-->");
            tmp = tmp.next;
        }
        System.out.print("NULL"+"\n");
    }
    public void print(Node node){
        if (node ==  null)return;
        System.out.println(node.data+" ");
        print(node.next);
    }

    public void findTheMiddleElement(int size){
        Node2 current = head;
        int k =1;
        int count = size/2;
        //System.out.println("count :"+count);
        while(current != null && count+1 > k){
            current = current.next;
            k++;
        }
        System.out.println("Middle element : "+current.data);

    }
}

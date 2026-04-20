package linkedList;

public class DeleteNNodesAfterMNodes {
    Node4 head;

    class Node4{
        int data;
        Node4 next;
        Node4(int data){this.data=data;next=null;}
    }

    public static void main(String[] args) {
        DeleteNNodesAfterMNodes list = new DeleteNNodesAfterMNodes();
        list.push(10);
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        System.out.println("Given List");
        list.print();
        list.deleteNodesAfterMNodes(2,2);
        System.out.println("After modification of list");
        list.print();
    }

    public void push(int data){
        Node4 node = new Node4(data);
        node.next =head;
        head = node;
    }

    public void print(){
        Node4 cur = head;
        while (cur !=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println(" ");
    }

    /**
     * Given a linked list and two integers M and N.
     * Traverse the linked list such that you
     * retain M nodes then delete next N nodes,
     * continue the same till end of the linked list.
     * @param m n
     */
    public void deleteNodesAfterMNodes(int m,int n){
        m = m-1;
        Node4 cur = head;
        Node4 p = null;
        if(cur == null) return;
        while(cur.next !=  null ){
            m--;
            //System.out.println("cur :"+cur.data);
            if(m >= 0) {
                cur = cur.next;
                p = cur;
            }
            if(m==0){
                while (p!=null && n > 0){
                       p = p.next;
                      //System.out.println("temp inner :"+p.next!=null?p.data:null);
                    n--;
                }
                //System.out.println("p.next::" +p.next);
                cur.next = p;
                n=2;
                m=2;
            }
        }
    }
}

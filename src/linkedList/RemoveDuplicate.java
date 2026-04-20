package linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate {
        static Node1 head;

        /* Node Class */
        class Node1
        {
                int data;
                Node1 next;
                // Constructor to create a new node
                Node1(int d) {data = d; next = null; }
        }

        public static void main(String[] args) {
                RemoveDuplicate list = new RemoveDuplicate();
                list.addAtFront(5);
                list.addAtFront(4);
                list.addAtFront(2);
                list.addAtFront(2);
                list.addAtFront(1);
                System.out.println("Given List");
                list.printList();
                System.out.println("Removing after duplicate");
                head = list.RemoveDuplicate();
                list.printList();
                /*System.out.println("Removing after duplicate");
                head = list.removeDups();
                list.printList();*/

        }

        public void addAtFront(int data)
        {
                /* 1 & 2: Allocate the Node &  Put in the data*/
                Node1 node = new Node1(data);
                /* 3. Make next of new Node as head */
                node.next = head;
                /* 4. Move the head to point to new Node */
                head = node;
        }
        public void printList(){
                Node1 tmp = head;
                while(tmp!=null){
                        System.out.print(tmp.data+"-->");
                        tmp = tmp.next;
                }
                System.out.print("NULL"+"\n");
        }

        public Node1 RemoveDuplicate() {
                Node1 prev = head;
                Node1 curr = prev;
                if (curr.next != null) curr = prev.next;

                while (curr != null) {
                        if (prev.data == curr.data && curr.next != null) {
                                prev.next = curr.next;
                                curr = curr.next;
                        }
                        else if (prev.data == curr.data && curr.next == null) {
                                prev.next = null;
                                break;
                        }
                        else {
                                prev = curr;
                                curr = curr.next;
                        }
                }

                return head;
        }

        public Node1 removeDups(){
             //List<Node1> list = new ArrayList<>();
             Map<Integer ,Node1> map = new HashMap<>();
             Node1 cur = head;
             Node1 new_node = null;
             while(cur !=null){
                     if(!map.containsKey(cur.data)){
                             map.put(cur.data,cur);
                     }
                     cur = cur.next;
             }
             for(Map.Entry<Integer,Node1> entry : map.entrySet()){
                     System.out.println(entry.getKey() +" node data: "+entry.getValue().data);
                     if(new_node ==null) {

                             new_node = entry.getValue();
                             System.out.println(new_node.data);
                     }
                     else{
                             System.out.println(entry.getValue().data);
                             new_node.next = entry.getValue();
                             break;
                     }


             }
             return new_node;
        }
}

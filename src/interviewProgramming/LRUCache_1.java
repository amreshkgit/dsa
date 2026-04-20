package interviewProgramming;


import java.util.HashMap;

/**
 * https://www.baeldung.com/java-lru-cache using linkedHashMap
 */
//Doubly linked list
class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache_1 {
    int capacity;
    HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;

    public LRUCache_1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addFirst(node);
            return;
        }
        //if above condition false means no element in the cache and creates the new node
        Node node = new Node(key, value);

        //check cache is not full
        if (cache.size() == capacity) {
            cache.remove(tail.key);
            removeNode(tail);
        }

        cache.put(key, node);
        addFirst(node);
    }

/*    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }*/

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        System.out.println(prevNode.value);
        Node nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
            //System.out.println(nextNode.prev.value);
        } else {
            tail = prevNode;
            //System.out.println();
        }
    }

    private void addFirst(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }


    public static void main(String[] args) throws java.lang.Exception {
        LRUCache_1 lrucache = new LRUCache_1(2);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));

    }
}


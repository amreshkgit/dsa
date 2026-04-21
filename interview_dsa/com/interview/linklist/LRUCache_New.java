package com.interview.linklist;

import java.util.HashMap;

class LRUCache_New {

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache_New(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail nodes for easier management
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public Integer get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            // Remove from the tail (least recently used node)
            Node lru = tail.prev;
            remove(lru);
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    // Helper to remove a node from the list
    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper to insert a node right after the head (most recently used)
    private void insertToFront(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Main method to test the LRUCache
    public static void main(String[] args) {
        LRUCache_New cache = new LRUCache_New(2); // Capacity of 2

        cache.put(1, 1);
        System.out.println("Get 1: " + cache.get(1)); // returns 1

        cache.put(2, 2);
        System.out.println("Get 2: " + cache.get(2)); // returns 2

        cache.put(3, 3);  // evicts key 1
        System.out.println("Get 1 after eviction: " + cache.get(1)); // returns -1 (not found)

        cache.put(4, 4);  // evicts key 2
        System.out.println("Get 2 after eviction: " + cache.get(2)); // returns -1 (not found)

        System.out.println("Get 3: " + cache.get(3)); // returns 3
        System.out.println("Get 4: " + cache.get(4)); // returns 4
    }
}

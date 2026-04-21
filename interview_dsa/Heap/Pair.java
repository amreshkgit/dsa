package Heap;

public class Pair implements Comparable<Pair> {
    int key;
    int data;

    Pair(int key, int data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public int compareTo(Pair o) {
        return this.key - o.key;
    }
}

package Heap;

public class NestedPair implements Comparable<NestedPair>{
    public int key;
    public Coordinate coordinate;

    public NestedPair(int key, Coordinate coordinate) {
        this.key = key;
        this.coordinate = coordinate;
    }

    @Override
    public int compareTo(NestedPair o) {
        return this.key - o.key;
    }

}

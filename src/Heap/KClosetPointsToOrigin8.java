package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We have to find two closet point from origin
 * Trick to solve the problem
 * find the distance from the origin using formula x^2 + y^2 under root
 * but here we will use the x square + y square example here we have 1,3 then distance will 1^2 + 3^2 = 10
 * Now, we will store distance as key and coordinate pair as value in the max heap.
 * So that max heap will sort the value based on value of the key
 *
 *
 */
public class KClosetPointsToOrigin8 {
    public static void main(String[] args) {
        int[][] ar = {{1,3},{-2,2},{5,8},{0,1}};
        kClosetPointToOrigin(ar,2);
    }

    static void kClosetPointToOrigin(int[][] a, int k){

        PriorityQueue<NestedPair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<a.length;i++){
            maxHeap.add(new NestedPair(a[i][0]*a[i][0] + a[i][1]*a[i][1], new Coordinate(a[i][0],a[i][1])));
             // a[i][0]*a[i][0] + a[i][1]*a[i][1] Nothing but (X square + Y square)
            // new Coordinate(a[i][0],a[i][1]) to store actual coordinate value so that we will print the answer later
            //check if heap reaches to greater than k size
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        //Print the remaining element from the heap
        while (maxHeap.size() > 0){
            Coordinate coordinate = maxHeap.poll().coordinate;
            System.out.println(coordinate.coordinateX + ","+coordinate.coordinateY);
        }

    }
}

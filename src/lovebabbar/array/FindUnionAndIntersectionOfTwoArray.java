package lovebabbar.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Union - retrun all removing duplicate elements from two array
 * example - a[] ={5,10,15,5} b[] = {10,15,4,5} ans {5,10,15,4}
 * Intersection - return all unique element between two array
 */
public class FindUnionAndIntersectionOfTwoArray {
    public static void main(String[] args) {
     int a [] ={5,10,15,5,10};
     int b [] ={15,5,5,10,4};
    }

    //complexity O(n+m) where n is size of a array and m is the size b array
    public static int union(int []a,int []b) {
        Set<Integer> set = new HashSet<>();
        //n size
        for(int x:a){
            set.add(x);
        }
        //m size
        for(int x:b){
            set.add(x);
        }
        return set.size();
    }

    public static int intersection(int[]a,int[]b){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int x:a){
            set.add(x);
        }
        for(int x : b){
            if(set.contains(x)){
                count++;
                set.remove(x);
            }
        }
        return count;
    }

}

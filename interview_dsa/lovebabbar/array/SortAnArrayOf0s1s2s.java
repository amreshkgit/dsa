package lovebabbar.array;

import java.util.stream.IntStream;

/**
 * Trick
 * 1. Take three pointer start mid and high
 * 2. start and mid will point start and high will point end
 * 3. check mid is equals to zero then swap start with mid ++start and ++mid
 * 4. check mid is equals to 2 then swap mid with high and decrease high
 */
public class SortAnArrayOf0s1s2s {
    public static void main(String[] args) {
        int [] array ={2,1,0,1,2,1,2,0,0,0,1};
        sort(array);
        System.out.println("-----Sorted Array of 0's 1's 2's-----");
        IntStream.of(array).forEach(x -> System.out.print(x+" "));
        /*for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }*/
    }

    public static void sort(int[] array){
        int start=0,mid=0;
        int high = array.length-1;
        while(mid <= high){
            if(array[mid]==0){
                int lo = array[start];
                array[start] = array[mid];
                array[mid] = lo;
                //swap(array,low,high);
                ++start; ++mid;
            }else if(array[mid] == 2){
                int mi = array[mid];
                array[mid] = array[high];
                array[high] = mi;
               // swap(array,mid,high);
                --high;
            }else {
                ++mid;
            }
        }
    }


}

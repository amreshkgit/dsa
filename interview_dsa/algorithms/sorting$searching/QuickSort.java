package algorithms.sorting$searching;

import java.util.stream.IntStream;

//The best-case time complexity of quicksort is O(n*logn).
//The average case time complexity of quicksort is O(n*logn)
public class QuickSort {
    public static void main(String[] args) {
        int[] A={7,2,1,6,8,5,3,4};
        quickSort(A,0, 7);
        IntStream.of(A).forEach(x-> System.out.print(x+" "));
        //Arrays.asList(A).stream().forEach(x->System.out.print(x+" "));
    }


    static void quickSort(int[]A,int start,int end){
        //This condition will take care two things
        //1. if segment is invalid
        //2. if segment has only element
        if(start < end){
            int pIndex = partition(A,start,end);
            quickSort(A,start,pIndex-1);
            quickSort(A,pIndex+1,end);
        }
    }

    //This partition function is to arrange the list in such a way
    // that element lesser than pivot will go to left of PIndex and greater than
    // pivot will go to right at end of the partition
    static int partition(int[]A, int start, int end){
        //int random = new Random().ints(start,end+1).findFirst().getAsInt();
        int pivot = A[end];
        int PIndex = start;
        for (int i=start; i<end;i++){
            if(A[i] <= pivot){
                //Swap(A[i],A[PIndex])
                int temp = A[i];
                A[i] = A[PIndex];
                A[PIndex] = temp;
                PIndex++;
            }
        }
        //Swap(A[PIndex],A[end])
        int temp = A[PIndex];
        A[PIndex] = A[end];
        A[end] = temp;
        return PIndex;
    }
}

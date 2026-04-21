package interviewProgramming;

import java.util.stream.IntStream;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a ={2,5,7};
        int[] b ={3,4,9};
        int[] res = merge(a,b,3,3);
        IntStream.of(res).forEach(x -> System.out.print(x+" "));
    }

    public static int[] merge(int[] a, int [] b, int n , int m){
        int[] res = new int[n+m];

        int i=0,j=0,k=0;

        while (i<n && j<m){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
            }else{
                res[k]=b[j];
                j++;
            }
            k++;
        }
        while (i<n){
            res[k] = a[i];
            i++;k++;
        }
        while (j<m){
            res[k] = b[j];
            j++;k++;
        }
        return res;
    }
}

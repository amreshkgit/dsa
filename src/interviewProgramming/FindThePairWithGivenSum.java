package interviewProgramming;

import java.util.Arrays;

public class FindThePairWithGivenSum {
    public static void main(String[] args) {
        int[] A={5,8,3,4,2,6,10,7,1,9};
        Arrays.sort(A);
        findPairsWithGivenSum(A,10,11);
    }

    static void findPairsWithGivenSum(int [] A,int n,int sum){
        int low=0, high=n-1;
        while (low<high){
            if(A[low]+A[high] > sum){
                high--;
            }else if(A[low]+A[high] < sum){
                low++;
            }else{
                System.out.println("("+A[low]+","+A[high]+")");
                low++;
            }
        }

    }
}

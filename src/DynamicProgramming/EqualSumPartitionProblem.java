package DynamicProgramming;

/**
 * Given an array arr[], determine if it can be partitioned
 * into two subsets such that the sum of elements in both parts is the same.
 */
public class EqualSumPartitionProblem {
    public static void main(String[] args) {
        int[] arr ={2,4,5,7};
        EqualSumPartitionProblem p = new EqualSumPartitionProblem();
        System.out.println(p.equalSumPartition(arr));
    }

    public boolean equalSumPartition(int[] arr){
        int sum =0;
        for(int i : arr){
            sum +=i;
        }
        if(sum % 2 !=0)return false;
        else return subset(arr,sum/2);
    }

    private boolean subset(int[] arr, int sum) {
        return SubsetSumProblem.hasSubset(arr,sum,arr.length);
    }
}

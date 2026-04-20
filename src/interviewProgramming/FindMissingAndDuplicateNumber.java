package interviewProgramming;

/**
 * Cyclic sort or swap sort to find the duplicate and missing number
 *
 */
public class FindMissingAndDuplicateNumber {
    public static void main(String[] args) {
        int[] ar = {2,3,1,5,1};
        int[] res = findMissingAndDuplicate(ar);
        for(int i =0;i<res.length;i++){
            if(ar[i] !=i+1){
                System.out.println("Missing number: "+(i+1));
                System.out.println("Duplicate number: "+ar[i]);
            }
        }
    }

    public static int[] findMissingAndDuplicate(int[] ar){
        int i = 0;
        while (i < ar.length){
            if(ar[i] != ar[ar[i]-1]){
                //Swap the ele
                int temp = ar[ar[i]-1];
                ar[ar[i]-1] = ar[i];
                ar[i] = temp;
            }else{
                i++;
            }
        }
        return ar;
    }
}

package DynamicProgramming;

public class LongestIncreasingSubsequenceRecursive {
    public static void main(String[] args) {
        int[] arr = {3,10,2,1,20,30,40};
        int maxLen = 0;
        /*int len = lcsIncreasingSub(arr,arr.length,0,0);
        maxLen = len;
        if(len >maxLen) maxLen = len;
         maxLen= maxLen +1;
         System.out.println(maxLen);*/
        int[] ar = lis(arr,arr.length);
        printTheSequence(ar,arr);

    }

    //Time complexity 2^n
    public static int lcsIncreasingSub(int[] arr,int len,int i,int j){
        if(len <= 0 )
            return 0;
        if(arr[i] < arr[j])
             return  1+lcsIncreasingSub(arr,len-1,i+1,j+1);
        else
           return  lcsIncreasingSub(arr,len-1,i,j+1);
    }

   //O(n^2)
    public static int[] lis( int arr[], int n )
    {
        int [] lis = new int[n];

        lis[0] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for (int i = 1; i < n; i++ )
        {
            lis[i] = 1;
            for (int j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1; //Iterative Structure to fill the table
        }

        // Return maximum value in lis[]
        return lis;
    }

    public static void printTheSequence(int[] lis,int[] arr){
      //  Stack<Integer> s = new Stack<>();
       // int cur = lis[lis.length-1];
       // System.out.print(arr[lis.length-1] +" ");
       // s.push(arr[lis.length-1]);
        /*for(int i = lis.length ; i>0 ;i--){
            if(cur - 1 == lis[i-1] ){
                cur = lis[i-1];
                System.out.print(arr[i-1] +" ");
               // s.push(arr[i-1]);
                //n/ = lis[i];
            }
        }*/
      /* while (s.size() > 0){
           System.out.print(s.pop()+" ");
       }*/
      int cur = lis[0];
        System.out.print(arr[0] +" ");
        for(int i = 0 ; i < lis.length-1;i++){
            if(cur + 1 == lis[i+1] ){
                cur = lis[i+1];
                System.out.print(arr[i+1] +" ");
            }
        }
    }
}

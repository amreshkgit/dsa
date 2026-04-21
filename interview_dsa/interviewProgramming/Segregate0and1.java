package interviewProgramming;

public class Segregate0and1 {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 0, 1, 1};
        //int arr[] = new int[]{0,1,1,0,1,0,1,2,2};
        int i, arr_size = arr.length;
        Segregate0and1 segregate = new Segregate0and1();
        //segregate.segregate0and1(arr,arr_size);
        segregate.segregate(arr);

        System.out.println("------Array after segregation is-----");
        for (i = 0; i < 5; i++)
            System.out.print(arr[i] + " ");
    }

    void segregate0and1(int [] arr,int size){
        int left = 0, right = size - 1;

        while (left < right)
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;

            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }

    void segregate(int[] arr){
         int left = 0, right = 0;
         int tmp;
         while (right < arr.length){
             if(arr[right] == 0){
                 ++right;
             }else {
                 tmp = arr[left];
                 arr[left] = arr[right];
                 arr[right] = tmp;
                 ++left;
                 ++right;
                 //count ++;
             }
         }
     }
}

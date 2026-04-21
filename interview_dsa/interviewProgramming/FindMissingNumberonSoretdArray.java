package interviewProgramming;

public class FindMissingNumberonSoretdArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 7, 8, 9};
        // int num = findMissing(arr,8);
        // System.out.println(num);
        int n = findMissingNumber(arr, 8);
        System.out.println(n);
        int n1 = findMissingNumber1(arr, 8);
        System.out.println(n1);
    }

    static int findMissing(int arr[], int N) {
        int left = 0, right = N - 1;
        while (left <= right) {

            int mid = (left + right) / 2;

            // If the middle element is not on
            // the middle index, then the missing element is mid + 1.
            if (arr[mid] != mid + 1 && arr[mid - 1] == mid) {
                return mid + 1;
            }

            // This case means that the missing element is
            // not to the left. So search the right.
            if (arr[mid] == mid + 1)
                left = mid - 1;

                // This case means that the missing element is not
                // to the right. So search the left.
            else
                left = mid + 1;
        }

        // Will reach here if no missing element found.
        return -1;
    }

    static int findMissingNumber(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);

    }

   static int findMissingNumber1(int A[], int n)
    {
        boolean B[] = new boolean[n + 1];
        for(int i = 0; i < n-1; i++)
            B[A[i]] = true;

        int missing = 0;
        for(int i = 1; i < B.length; ++i)
            if(!B[i]) missing = i;

        return missing;
    }

    /**
     * Another approach that avoids the use of extra memory is to sum up all the elements
     * in the array and subtract that value from the total sum which can be obtained with the following formula (n * (n + 1)) / 2
     * @param A
     * @param n
     * @return
     */
    int findMissingNumber2(int A[], int n)
    {
        int total = (n * (n + 1)) / 2;
        int sum = 0;
        for(int i = 0; i < A.length; ++i)
            sum += A[i];

        return total - sum;
    }
}

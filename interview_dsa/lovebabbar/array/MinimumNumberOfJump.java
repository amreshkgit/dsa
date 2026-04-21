package lovebabbar.array;

public class MinimumNumberOfJump {
    public static void main(String[] args) {
        int[] steps= {1,2,5,6,3,7,8,9,10};
        System.out.println(findMinimumNumberOfJump(steps,2));
    }

    public static int findMinimumNumberOfJump(int[] a, int n) {
        if (n <= 1)
            return 0;

        // if first element is zero then we can't go forward
        if (a[0] == 0)
            return -1;

        int maxReach = a[0];
        int step = a[0];
        int jump = 1;

        int i = 1;
        for (i = 1; i < n; i++) {
            if (i == n - 1) { // when we come to last index then return jump
                return jump;
            }
            maxReach = Math.max(maxReach, i + a[i]);
            step--;
            // step become zero and we need jump
            if (step == 0) {
                jump++;
                if (i >= maxReach) { // when index is greater than max reach then we return -1 because that become invalid scenario
                    return -1;
                }
                step = maxReach - i;
            }
        }
        return jump;
    }
}

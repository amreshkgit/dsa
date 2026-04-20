package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountDistinctElementsInWindowK {
    public static void main(String[] args) {
     int arr[] ={31 ,31 ,10 ,92 ,84};
        System.out.println(countDistinct(arr,arr.length,2));
    }

    static List<Integer> countDistinct(int A[], int n, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0, i = 0;
        while (j < n) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            if (j - i + 1 == k) {
                ans.add(map.size());
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0)
                    map.remove(A[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}

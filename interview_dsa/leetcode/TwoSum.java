package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create an map then take the target sum and minus the element at each index in the given array
 * ex: {3,2,4} sum target = 6
 *  first we will do 6-3 = 3 check 3 present in map or not
 *  second 6-2 = 4 check 4 present in map or not
 *  third 6- 4 = check 2 present in map or not
 */
public class TwoSum {
    public static List<Integer> twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                list.add(map.get(target - nums[i]));
                list.add(i);
            }
            map.put(nums[i],i);
        }
        return list;
    }

    public static void main(String[] args) {
        int [] num = {3,2,4}; //[2,7,11,15]//[3,3],
       // TwoSum solution = new Solution();
        System.out.println(twoSum(num,6));
    }
}

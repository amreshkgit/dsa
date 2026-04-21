package interviewProgramming;

import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,-1,5};
        subArraySum(arr,0);

    }
    public static void subArraySum(int [] a, int sum){
        int currSum = 0;
        int start = 0;
        int end = -1;
        //key - currSum value - index
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i< a.length;i++){
            currSum += a[i];
            if(currSum - sum == 0){
                end = i;
                break;
            }
            if(map.containsKey(currSum-sum)){
                start = map.get(currSum-sum) +1;
                end = i;
                break;
            }
            map.put(currSum,i);
        }
        if ((end == -1)){
            System.out.println("not found");
        }else{
            System.out.println(start+" "+end);
        }
    }
}

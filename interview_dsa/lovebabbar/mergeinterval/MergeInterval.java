package lovebabbar.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    public static void main(String[] args) {
       int [][] interval={{0,5},{5,10},{15,25},{40,60},{50,65},{55,75}};
       int[][] events= {{1,2},{2,3},{3,4}};

        System.out.println(mergeIntervals(events).length);
        Arrays.stream(mergeIntervals(events)).forEach(x-> System.out.print(Arrays.toString(x) +" "));
    }

    // complexity will be nlogn
    public static int[][] mergeIntervals(int[][] Intervals){
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[0])); //sorted increasing order
        ArrayList<int[]> list = new ArrayList<>();

        for(int[] interval : Intervals){
            if(list.size() ==0) {
                list.add(interval);
            }else{
                int[] prevInterval = list.get(list.size()-1);
                if(interval[0] <= prevInterval[1]){ // to check overlapping
                    prevInterval[1] = Math.max(prevInterval[1],interval[1]);
                }else{
                    list.add(interval);
                }
            }
        }
        //return list.size();
        return list.toArray(new int[list.size()][]);
    }
}


package interviewProgramming;

import java.util.ArrayList;
import java.util.List;

/*
You have to find out count of those numbers which have their reverse number present.
Complexity of the program should be O(n) what is using one loop.
 */
public class CountReverseNumberPresent {
    public static void main(String[] args) {
        int j=0;
        int [] array ={ 21,43,84,34,45,55,26,48};
        List list = new ArrayList();
        for(int i=0;i<array.length;i++){
            int reversenum =0;
            int num =array[i];
            while( num != 0 )
            {
                reversenum = reversenum * 10;
                reversenum = reversenum + num%10;
                num = num/10;
            }
            list.add(reversenum);
            //System.out.println(list);
            if(list.contains(array[i]) && reversenum != array[i]){
                System.out.println("("+array[i]+","+reversenum+")");
            }


        }
    }
}

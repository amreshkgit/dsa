package lovebabbar.stackandqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {

    }

    public List<Object[]> interval(int[][] a, int[][] b) {
        List<Object[]> res = new ArrayList<>();
        int aptr = 0, bptr = 0;
        int sizea = a.length;
        int sizeb = b.length;
        if (a.length == 0 || b.length == 0)
            return Collections.singletonList(res.toArray(new Object[0][0]));
        //Iterate over all intervals and store answer
        while (aptr < sizea && bptr < sizeb) {
            List<Integer> tempL = new ArrayList<>();
            if (b[bptr][0] <= a[aptr][1] && a[aptr][0] <= b[bptr][1]) {
                int max = Math.max(a[aptr][0], b[bptr][0]);
                int min = Math.min(a[aptr][1], b[bptr][1]);
                tempL.add(min);
                tempL.add(max);
                res.add(tempL.toArray());
            }
            //Now increment either Aptr or Bptr conditionally
            if (a[aptr][1] > b[bptr][1])
                bptr += 1;
            else
                aptr += 1;
        }
        return res;
    }
}

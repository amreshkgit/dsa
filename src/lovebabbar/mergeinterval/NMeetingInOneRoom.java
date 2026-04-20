package lovebabbar.mergeinterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface NMeetingInOneRoom {
    public static void main(String[] args) {
     int [] start = {0,3,1,5,5,8};
     int [] end   = {5,4,2,9,7,9};
      System.out.println(  maxMeetings(start,end,6));
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++){ // O(N)
            meetings.add(new Meeting(start[i],end[i]));
        }
        meetings.sort(Comparator.comparingInt(m -> m.end)); //nlogn
        int lastEnd= -1;
        int count=0;

        for(Meeting meet: meetings){ // O(n)
            if(meet.start > lastEnd){
                lastEnd=meet.end;
                count++;
            }
        }
        return count;
    }
   // TC(2N+Nlogn)
    //SC O(3XN)+O(N)
}

class Meeting{
    int start;
    int end;
    public Meeting(int s, int e) {
        this.start = s;
        this.end = e;
    }

}

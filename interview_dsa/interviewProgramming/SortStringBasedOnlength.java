package interviewProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringBasedOnlength {
    public static void main(String[] args) {
        String[] s ={"ok", "is", "ok"};
        List<String> friends = Arrays.asList("ok", "is", "ok");
        StringBuffer buffer = new StringBuffer();
        //collection.Comparable.Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
        //Stream<String > s=  friends.stream().sorted(compByLength)
        Arrays.sort(s, Comparator.naturalOrder());
        System.out.println(Arrays.toString(s));
    }
}

package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "totmtaptat"; //timetopractice
        String t = "tta";
        minimumWindowSubString(s,t);
    }

    /**
     * Stsps to solve
     * 1. search for an answer by incrementing end++
     * 2. Jab answer mil jata hai i.e count ==0 and increment start tab tak while count ==0
     * @param s
     * @param t
     */
    public static void minimumWindowSubString(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (tLen > sLen)
            System.out.println("Invalid Input");
        HashMap<Character, Integer> countMap = new HashMap<>();
        //Traverse all the char from t string along with the count
        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        //sliding window hum start and end hamesa ek jagah se start karte hai isliye yanhan start
        //bhi 0 hai aur end bhi 0 hai
        int start = 0; // start of window
        int end = 0; // end of window

        int maxLen = Integer.MAX_VALUE;
        int maxStart = 0; // to track Start index of substring
        int maxEnd = 0; // to track End index of substring

        int count = countMap.size();

        while (end < sLen) {
            char tempCharEnd = s.charAt(end);
            //if above countMap contains char from the s string then decrement the count of character
            if (countMap.containsKey(tempCharEnd)) {
                countMap.put(tempCharEnd, countMap.get(tempCharEnd) - 1);
                //Once we get all char from the t in s then we will decrement the count
                if (countMap.get(tempCharEnd) == 0) {
                    count--;
                }
            }
            //when count become zero that means we have found all char in s from t string.i.e toct
            //iska matlabe hai possible substring mil gaya jisme t string present hai
            while (count == 0) {
                if (maxLen > end - start + 1) {
                    maxLen = end - start + 1;
                    maxStart = start;
                    maxEnd = end +1;
                }
                //code se find karenge ki possible substring se aur chota string nikal sakte hai kiya
                char tempCharStart = s.charAt(start);
                if (countMap.containsKey(tempCharStart)) {
                    countMap.put(tempCharStart, countMap.get(tempCharStart) + 1);
                    if (countMap.get(tempCharStart) > 0) {
                        count++; //when count become 1 that means we have no longer answer and again we
                        // need to increment the end and starting finding the answer
                    }
                }
                start++; //start to tab tak inc karenge jab tak count equal to 1 na jo jata
            }
            end++; // isko tab tak increase karenge jab tak count zero na jo jaye
        }
        System.out.println(maxLen);
        System.out.println("Start Index : " + maxStart +" and End Index : " + (maxEnd-1) + " \nsubstring: "+ s.substring(maxStart,maxEnd));
    }
}


package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcdfabbcddaa";
        System.out.println(findMaxLen(s));
        System.out.println(lengthOfLongestSubString(s));
    }
    public static int findMaxLen(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0; int right = 0;
        int n = s.length();
        int len = 0;
        while (right < n){
          if(map.containsKey(s.charAt(right))) {
              left = Math.max(map.get(s.charAt(right)) + 1, left);
          }
              map.put(s.charAt(right),right);
              len = Math.max(len,right-left+1);
              right++;
        }
        return len;
    }

    public static int lengthOfLongestSubString(String s){
        int left = 0, right = 0;
        Set<Character> seen = new HashSet<>();
        int max = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            if(seen.add(c)){
                max = Math.max(max,right-left+1);
                right++;
            }else {// when we get the duplicate character
                while (s.charAt(left)!=c){ // then remove the all char from left including duplicate
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);// remove the duplicate character
                left++;
            }
        }
        return max;
    }

}

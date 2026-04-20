package SlidingWindow;


import java.util.HashMap;
import java.util.Map;

class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String pattern = "for";
        System.out.println(countAnagrams(str,pattern));
    }
    public static int countAnagrams(String input, String pattern) {
        if (pattern == null || "".equals(pattern) || input == null || "".equals(input)) {
            return -1;
        }
        int windowSize = pattern.length();
        int i = 0, j = 0, count, result = 0;

        Map<Character, Integer> countMap = new HashMap<>();

        //Step1 populate map for pattern
        for (int k = 0; k < pattern.length(); k++) {
            countMap.put(pattern.charAt(k),countMap.getOrDefault(pattern.charAt(k),0)+1);
        }
        //step2. count of distinct characters
        // Taking count to avoid to traverse map the everytime
        count = countMap.keySet().size();

        //step 3.
        while (j < input.length()) {
            //This is calculation part --start
            // calculation for character at end of window
            if (countMap.containsKey(input.charAt(j))) {
                countMap.put(input.charAt(j), countMap.get(input.charAt(j)) - 1);
            }
            if (countMap.get(input.charAt(j)) != null && countMap.get(input.charAt(j)) == 0) {
                count--; // when we hit zero for distinct char in map so, everytime we should not look at map
            }
            //--End of calculation part

            //step 4.
            if (j - i + 1 < windowSize) {
                j++;
            }
            //step 5. slid the window
            else if(j-i+1 == windowSize){
                if (count == 0) {
                    result++;
                }
                char startChar = input.charAt(i);
                // calculation for character at moving out of window
                if (countMap.containsKey(startChar)) {
                    countMap.put(startChar, countMap.get(startChar) + 1);
                }
                if (countMap.get(startChar) != null && countMap.get(startChar) == 1) {
                    count++;
                }

                i++; // this is to slid the window
                j++; // this is for slide the window
            }

        }
        return result;
    }
}
package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        System.out.println(find(s,3));
    }

   // Time Complexity: time complexity of below solution is O(n).
    public static int find(String s,int k){
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0,j=0;
        int max = Integer.MIN_VALUE;

        while (j< s.length()){
            char tempCharEnd = s.charAt(j);
            map.put(tempCharEnd,map.getOrDefault(tempCharEnd,0)+1);
            if(map.size() < k){
                j++;
            }
            //we have hit the window size jiske andar unique char
            if(map.size() == k){
                max = Math.max(max,j-i+1); // j-i+1 length of substring
                j++;
            }else if(map.size() > k){
                //Yahan we will remove char for cal i
                while (map.size() > k){
                    if(map.containsKey(s.charAt(i))) {
                        int freq = map.get(s.charAt(i));
                        map.put(s.charAt(i), freq - 1);
                    }
                    //Once char count become zero in the map then remove from the map to maintain
                    //the size of K unique char in the map
                    if(map.get(s.charAt(i)) == 0){
                        map.remove((s.charAt(i)));
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println("Max substring is : "+ s.substring(i,i + max));
        return max;
    }

    public static int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int i =0;
        int j =0;
        int maxStringlen=-1;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(hm.containsKey(ch)){
                int freq=hm.get(ch);
                freq++;
                hm.put(ch,freq);
            }
            else{
                hm.put(ch,1);
            }

            if(hm.size()<k){
                j++;
            }
            else if(hm.size()==k){
                maxStringlen=Math.max(maxStringlen,j-i+1);
                j++;
            }
            else if(hm.size()>k ){
                while(hm.size()>k && i<s.length()){

                    if(hm.containsKey(s.charAt(i))){
                        int freq=hm.get(s.charAt(i));
                        freq--;
                        hm.put(s.charAt(i),freq);
                    }
                    if(hm.get(s.charAt(i))==0){
                        hm.remove(s.charAt(i));
                    }

                    i++;

                }
                j++;
            }
        }
        return maxStringlen;
    }

    public static int MaxSubtringSizeK(String s, int k ){
        int len = s.length();
        int answer=-1,i=0,j=0;
        HashMap<Character,Integer> hm = new HashMap<>(); // Map to store the frequency of each character

        while (j<len){
            //Sliding window Calculations
            char ch = s.charAt(j);
            //get the frequency of ch from Map and then increase it by 1 in the map.
            int chFrequencyInMap =   hm.getOrDefault(ch,0);
            hm.put(ch, chFrequencyInMap+1); //increase the frequency of current character in Map

            //Sliding Window Condition: hashmap.size = k  [OR number of Unique Characters =k];
            if (hm.size()>k){  /*Reduce the frequency of ith element by 1 and remove it from map if frequency becomes 0.
                                                 Keep doing above [reducing window size] till hm.size becomes <=k  */
                while(hm.size()>k){
                    char iChar = s.charAt(i);
                    int freqiChar = hm.get(iChar);
                    hm.put(iChar, freqiChar-1);
                    if (hm.get(iChar)==0)
                        hm.remove(iChar);
                    i++;
                }
            }

            if(hm.size() == k){ //unique chars = k , compute candidate answer.
                int currentAns = j-i+1;
                answer = Math.max(answer,currentAns);
            }

            j++; // increase window size and look for next window where sum = target
        }
        return answer;

    }
}

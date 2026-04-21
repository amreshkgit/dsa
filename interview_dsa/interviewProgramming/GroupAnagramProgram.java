package interviewProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramProgram {
    public static void main(String[] args) {
        String[] str ={"eat","tea","tan","ate","nat","bat"};
        System.out.println(findGroupAnagram(str));
        System.out.println(2+""+1);
    }

   static List<List<String>> findGroupAnagram(String[] strings){
        List<List<String>> groupedAnagram = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String current : strings){
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(current);
        }
        groupedAnagram.addAll(map.values());
        return groupedAnagram;
    }
}

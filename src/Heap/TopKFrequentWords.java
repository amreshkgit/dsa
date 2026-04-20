package Heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
      String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topkFrequent(words,2));
    }

    public static List<String> topkFrequent(String[] words,int k){
        Map<String,Integer> map = new HashMap<>();
        for (String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        //custom comparator to compare the words
        Queue<String> q = new PriorityQueue<>((w1,w2)->map.get(w1).equals(map.get(w2))? w2.compareTo(w1):map.get(w1)-map.get(w2));
        //add to heap
        for(String word: map.keySet()){
            q.add(word);
            if (q.size()> k){
                q.poll();
            }
        }

        //add to result
        List<String> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll());
        }
        Collections.reverse(list);
        return list;
    }
}

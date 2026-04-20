package interviewProgramming;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {

    private int size;
    private LRUCache(int size){
        super(size,0.75f,true);
        this.size = size;
    }
    public static <K,V> LRUCache<K,V> newInstance(int size){
        return new LRUCache<K,V>(size);
    }
    public void setMaxSize(int size){
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >size;
    }

    public static void main(String[] args) {
        LRUCache cache = LRUCache.newInstance(2);
        cache.put("2","2");
        cache.put("3","2");
        cache.put("1","2");
        System.out.println(cache.get("1"));
        System.out.println(cache);
    }
}

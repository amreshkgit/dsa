package java8;

import java.util.*;

public class SortMapByKey {
    public static void main(String[] args) {
        Employee e1 = new Employee(4,"A");
        Employee e2 = new Employee(3,"B");
        Employee e3 = new Employee(2,"C");
        Employee e4 = new Employee(1,"D");

        Map<Employee,Integer> map = new HashMap<>();
        map.put(e1,1);
        map.put(e2,2);
        map.put(e3,3);
        map.put(e4,4);
        for(Map.Entry entry:map.entrySet()){
            System.out.println("Key : "+entry.getKey()+"\t"+"Value :"+entry.getValue());
        }

        Map<Employee,Integer> sortedMap = new TreeMap<>(map);
        System.out.println("----Sorted Map By Key -------");
        for(Map.Entry entry:sortedMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+"\t"+"Value :"+entry.getValue());
        }

        Map<Employee,Integer> sortedByValue = sortByValue(map);
        System.out.println("----Sorted Map By value -------");
        for(Map.Entry entry:sortedByValue.entrySet()){
            System.out.println("Key : "+entry.getKey()+"\t"+"Value :"+entry.getValue());
        }
    }

    private static Map<Employee, Integer> sortByValue(Map<Employee, Integer> unsortMap) {
        // 1. Convert Map to List of Map
        List<Map.Entry<Employee, Integer>> list =new LinkedList<>(unsortMap.entrySet());
        System.out.println("list :: "+list);
        // 2. Sort list with Collections.sort(), provide a custom collection.Comparable.Comparator
       // Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        list.sort(Map.Entry.comparingByValue());
        System.out.println("Sorted list :: "+list);
        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        LinkedHashMap<Employee, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Employee, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}

class Employee implements Comparable {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;
        return this.id-e.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

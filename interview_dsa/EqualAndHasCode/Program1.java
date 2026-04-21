package EqualAndHasCode;

import java.util.HashMap;

/**
 * How many buckets will be there and what will be size of HashMap?
 * if no equals and hashcode overridden
 */
public class Program1 {
    public static void main(String...a){

        HashMap<Employee, String> hm=new HashMap<Employee, String>();
        hm.put(new Employee("a"), "emp1");
        hm.put(new Employee("b"), "emp2");
        hm.put(new Employee("a"), "emp1 OVERRIDDEN");

        System.out.println("HashMap's data> "+hm);
        System.out.println("HashMap's size> "+hm.size());
        System.out.println(hm.get(new Employee("a")));

    }
}

class Employee {

    private String name;

    public Employee(String name) { // constructor
        this.name = name;
    }


    //no hashCode() method

    //no equals() method

    @Override
    public String toString() {
        return "Employee[ name=" + name + "] ";
    }

}
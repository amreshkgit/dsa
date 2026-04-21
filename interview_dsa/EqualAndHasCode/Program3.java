package EqualAndHasCode;


import java.util.HashMap;

/**
 * Buckets= As hashCode() method returns 1, only 1 bucket location will be used.
 *
 * Size= As equals() method always returns true, size will be 1, all three employees will
 * be stored on same bucket location in one Entry (new Entry will keep on overriding previous Entry).
 * We will always get last stored key-value pair only.
 *
 * get()=we will be able to get object.
 */
class Employee2 {

    private String name;

    public Employee2(String name) { // constructor
        this.name = name;
    }

    @Override
    public int hashCode(){
        return 1;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    }

    @Override
    public String toString() {
        return "Employee[ name=" + name + "] ";
    }

}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class Program3 {
    public static void main(String...a){

        HashMap<Employee2, String> hm=new HashMap<Employee2, String>();
        hm.put(new Employee2("a"), "emp1");
        hm.put(new Employee2("b"), "emp2");
        hm.put(new Employee2("a"), "emp1 OVERRIDDEN");

        System.out.println("HashMap's data> "+hm);
        System.out.println("HashMap's size> "+hm.size());
        System.out.println(hm.get(new Employee2("a")));

    }
}
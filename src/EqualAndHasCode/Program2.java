package EqualAndHasCode;

import java.util.HashMap;

/**
 * Buckets= As hashCode() method is overridden perfectly, 2 bucket locations will be used.
 *
 * Size= As equals() method is their, size will be 2,
 * value corresponding to Employee with id=1 and name=’sam’ was employee1 data
 * & was overridden by value employee1 data OVERRIDDEN
 *
 * get()=we will be able to get object.
 */
class Employee1 {

    private String name;

    public Employee1(String name) { // constructor
        this.name = name;
    }

    @Override
    public int hashCode(){
        return (this.name==null ? 0: this.name.hashCode() );
    }

    @Override
    public boolean equals(Object obj){
        Employee1 emp=(Employee1)obj;
        return (emp.name==this.name || emp.name.equals(this.name));
    }

    @Override
    public String toString() {
        return "Employee[ name=" + name + "] ";
    }

}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class Program2 {
    public static void main(String...a){

        HashMap<Employee1, String> hm=new HashMap<Employee1, String>();
        hm.put(new Employee1("a"), "emp1");
        hm.put(new Employee1("b"), "emp2");
        hm.put(new Employee1("a"), "emp1 OVERRIDDEN");

        System.out.println("HashMap's data> "+hm);
        System.out.println("HashMap's size> "+hm.size());
        System.out.println(hm.get(new Employee1("a")));

    }
}
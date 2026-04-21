package collection.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Comparator can be used to compare instances of same or different classes in java.
 *
 * Comparator is implemented when one
 * wants a different sorting order and define custom
 * way of comparing two instances
 *
 * We can use Comparator to sort class on many criterias
 * because class itself or any other class can implement Comparator in java.
 */
public class ComparatorExample {
    public static void main(String[] args) {

        Employee emp1=new Employee("sam","4");
        Employee emp2=new Employee("amy","2");
        Employee emp3=new Employee("brad","1");

        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        System.out.println("list Before sorting : \n"+list);

        Collections.sort(list,new Employee());

        System.out.println("\nlist after sorting on basis of name(ascending order) : \n"+list);

        Collections.sort(list,new ComparatorName());
        System.out.println("\nlist after sorting on basis of name(ascending order) : \n"+list);

        Collections.sort(list,new ComparatorId());
        System.out.println("\nlist after sorting on basis of id(ascending order) : \n"+list);

    }
}

class Employee implements Comparator<Employee> {
    String name;
    String id;

    public Employee() {}

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compare(Employee obj1, Employee obj2) {
        //sort Employee on basis of name(ascending order)
        return obj1.name.compareTo(obj2.name);
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
}

class ComparatorName implements Comparator<Employee>{
    @Override
    public int compare(Employee obj1, Employee obj2) {
        //sort Employee on basis of name(ascending order)
        return obj1.name.compareTo(obj2.name);
    }
}



class ComparatorId implements Comparator<Employee>{
    @Override
    public int compare(Employee obj1, Employee obj2) {
        //sort Employee on basis of id(ascending order)
        return obj1.id.compareTo(obj2.id);
    }

}

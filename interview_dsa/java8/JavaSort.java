package java8;

import java.util.*;

public class JavaSort
{
    public static void main(String[] args)
    {
/*        ArrayList<Employee> employees = getUnsortedEmployeeList();

        //Compare by first name and then last name
        collection.Comparable.Comparator<Employee> compareByName = collection.Comparable.Comparator
                .comparing(Employee::getId)
                .thenComparing(Employee::getFirstName);
                //.thenComparing(Employee::getLastName);

        Collections.sort(employees, compareByName);

        System.out.println(employees);*/

        List<String> names = Arrays.asList("Antony","Melisandre","Sansa","Jon","Daenerys","Joffery");
        names.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);
        System.out.println("------ ORDERED LIST-------");
        names.stream().forEachOrdered(name -> System.out.println(name));

        Map<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1, "Monkey");
        hmap.put(2, "Dog");
        hmap.put(3, "Cat");
        hmap.put(4, "Lion");
        System.out.println("-----MAP-------");
        hmap.forEach((key,value) -> System.out.println(key +"\t"+value));
        hmap.forEach((key,value) ->
        { if(key.equals(1)) {
            System.out.println(value);
        }
         });
    }

    private static ArrayList<Employee> getUnsortedEmployeeList()
    {
        ArrayList<Employee> list = new ArrayList<>();
        list.add( new Employee(2, "Lokesh", "Gupta") );
        list.add( new Employee(1, "Alex", "Gussin") );
        list.add( new Employee(4, "Brian", "Sux") );
        list.add( new Employee(5, "Neon", "Piper") );
        list.add( new Employee(3, "David", "Beckham") );
        list.add( new Employee(7, "Alex", "Beckham") );
        list.add( new Employee(6, "Brian", "Suxena") );
        return list;
    }

    static class Employee{
        int id;
        String FirstName;
        String lastName;

        public Employee(int id, String firstName, String lastName) {
            this.id = id;
            FirstName = firstName;
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", FirstName='" + FirstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* WAP to find the highest paid salary employee from each dept
* */
public class FindHighestSalaryFromEachDeptUsingJava8 {
    public static void main(String[] args) {

        List<Emp> employees = Stream.of(new Emp(1,"Amresh","DEV",40000),
                new Emp(1,"John","DEV",30000),
                new Emp(1,"Devis","QA",5000),
                new Emp(1,"Jolly","QA",3000),
                new Emp(1,"Irena","OPS",14000),
                new Emp(1,"Elizabeth","OPS",13000)).collect(Collectors.toList());

        Comparator<Emp> bySalary = Comparator.comparing(Emp::getSalary);
        Map<String, Optional<Emp>>  highestSalaryByEachDept = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDept,Collectors.reducing(BinaryOperator.maxBy(bySalary))));
        System.out.print(highestSalaryByEachDept);




    }


}

class Emp{
    int id;
    String name;
    String dept;
    int salary;

    public Emp(int id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemostrateUseOfStreamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,3,4,0,7,6);

        BiggerThanFive<Integer> btf = new BiggerThanFive<>();
       // nums.stream().filter(btf).forEach(System.out::println);

        // create a list of integers
        List<Integer> number = Arrays.asList(2,3,4,5);
        List<Integer> number1 = Arrays.asList(3,4,5,2);

        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x*x).
                collect(Collectors.toList());
        System.out.println(square);

        // create a list of String
        List<String> names =
                Arrays.asList("Reflection","Collection","Stream");

        // demonstration of filter method
        List<String> result = names.stream().filter(s->s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<Integer> sortedNumber =
                number1.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumber);

    }

}

class BiggerThanFive<E> implements Predicate<List> {

   /* @Override
    public boolean test(Integer v) {

        Integer five = 5;

        return v > five;
    }*/

    @Override
    public boolean test(List list) {
        int i = (int) list.get(0);
        if(i ==0)
        return false;
        else
          return true;
    }
}


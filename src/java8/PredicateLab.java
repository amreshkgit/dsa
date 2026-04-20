package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateLab {
    public static void main(String[] args) {
        Predicate<Integer> isThree = x-> x==3;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> collect = list.stream() // convert list to stream
                .filter(isThree) //filter only
                .collect(Collectors.toList()); // collect the output and convert streams to a List


        //System.out.println(collect);
        collect.forEach(System.out::println);
    }
}

package java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountEachCharacterOfStringUsingJava8 {
    public static void main(String[] args) {
        String name = "Macbook";
        Map<String, Long> countByChar = Arrays.stream(name.split("")).collect(groupingBy(Function.identity(), counting()));
        System.out.println(countByChar);
    }
}

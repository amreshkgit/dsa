package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://stacktraceguru.com/overview-java-8-stream-api#:~:text=Streams%20internally%20iterate%20over%20the,of%20functions%20performed%20if%20any.&text=stream%20package%20was%20added%20in,or%20any%20collection%20of%20objects.
 * https://stackify.com/streams-guide-java-8/ -- Best guide
 */
public class User {

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

        public Integer getAge() {
        return age;
    }

        public String getName() {
            return name;
        }

    // other getters and setters

        @Override
        public String toString() {
        return "[" + name + ", " + String.valueOf(age) + "]";
    }
    }

// Find maximum and minimum value of a field among custom objects
// using Stream in Java 8 and above
class Main
{
    public static void main (String[] args)
    {
        List<User> users = Arrays.asList(new User("George", 15),
                new User("Tom", 10),
                new User("Mike", 12));

        // get user with minimum age
        User user1 = users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .get();

        System.out.println("User with Minimum age : " + user1);


        // get user with maximum age
        User user2 = users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .get();

        System.out.println("User with Maximum age : " + user2);

        System.out.println("---------------------------------------");
        // get user with minimum age
        User user3 = users.stream().min(Comparator.comparingInt(User::getAge)) .get();
        System.out.println("User with Minimum age : " + user3);
        // get user with maximum age
        User user4 = users.stream().max(Comparator.comparingInt(User::getAge))
                .get();
        System.out.println("User with Minimum age : " + user4);

        System.out.println("---Sort by Age-----");
        users.stream().sorted(Comparator.comparingInt(User::getAge).reversed()).limit(2).map(User::toString).forEach(System.out::println);

        System.out.println("---Sort by Name-----");
        //map() produces a new stream after applying a function to each element of
        //the original stream. The new stream could be of different type.
        users.stream().sorted(Comparator.comparing(User::getName)).limit(2).map(User::toString).forEach(System.out::println);

        users.stream().sorted(Comparator.comparing(User::getName)).map(User::toString).forEach(System.out::println);


       // Collect the names in the list

       List<String> listOfUser =  users.stream().sorted(Comparator.comparingInt(User::getAge)
                .reversed())
                .limit(2)
                .map(User::toString)
                .collect(Collectors.toList());//toSet() toMap() Collectors.groupingBy(e -> e.dept)
        System.out.println(listOfUser);

        Stream<String> names =  users.stream()
                .limit(2)
                .map(User::getName);
                //.collect(Collectors.joining(","));
        System.out.println(names);
    }
}
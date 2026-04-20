package java8;

import java.util.Arrays;
import java.util.Optional;

public class InterfaceDefaultMethodLab {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        //Sum of array
        int sum = Arrays.stream(arr).sum();
        System.out.println("Sum of an array : "+sum);

        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));

        oldInterfaceImpl obj = new oldInterfaceImpl ();
        oldInterfaceImpl1 obj1 = new oldInterfaceImpl1 ();

        // print “New default method add in interface”
        obj.newDefaultMethod();
        InterfaceB.anotherNewMethod();
        obj1.anotherNewMethod();
    }
}

interface InterfaceA {
    //public void existingMethod();
    default void newDefaultMethod() {
        System.out.println("New default method"+
                " is added in interface");
    }
}

interface InterfaceB{
    //public void existingMethod();
    default void newDefaultMethod() {
        System.out.println("New default method"+
                " is added in interface");
    }
    static void anotherNewMethod(){
        System.out.println("Newly added static method");
    }
}

interface InterfaceC extends InterfaceB{
    default void newDefaultMethod() {
        InterfaceB.super.newDefaultMethod();//to call method from the super interface
        System.out.println("New default method"+
                " is added in interface");
    }
    static void anotherNewMethod(){
        System.out.println("Newly added static method");
    }

}

class oldInterfaceImpl implements InterfaceA{
    @Override
    public void newDefaultMethod() {
        System.out.println("New default method"+
                " is added in interface");
    }
}

class oldInterfaceImpl1 implements InterfaceA,InterfaceB{
    @Override
    public void newDefaultMethod() {
        System.out.printf("new oldInterfaceImpl ...");
    }

    public void anotherNewMethod(){
        System.out.println("Newly added static method");
    }
}
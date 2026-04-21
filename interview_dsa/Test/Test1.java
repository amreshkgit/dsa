package Test;

public class Test1 {
    public static void main(String[] args) {
        A a = new B();
        a.add(5,6);
    }
}

class  A{
    public void add(int a, int b){
        System.out.println("add(int a, int b)");
    }
}

class B extends A{
    public void add(Integer A, Integer B){
        System.out.println("add(Integer A, Integer B)");
    }
}
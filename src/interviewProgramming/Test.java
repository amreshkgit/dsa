package interviewProgramming;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.m1(1);
        t.m1(new String());
        t.m1(new Object());
    }

    public void m1(Object o){
        System.out.println("Object");
    }
   /* public void m1(String str){
        System.out.println("String");
    }*/
    public void m1(Integer integer){
        System.out.println("Integer");
    }
   /* public void m1(int i){
        System.out.println("int");
    }*/


}

class Tt{
    public void m1(Object o) throws Exception{
        System.out.println("Object");
    }

}

class Gt extends Tt{

    public void m1(Object o) throws IOException {
        System.out.println("Object");
    }
}
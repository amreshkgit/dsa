package Test;

public class XecptionTest {
    public static void main(String[] args) throws Exception {
        Test();
    }

    static void Test() throws Exception {
        try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
            throw new TextException("df");
        } catch(Exception e)
        {
            System.out.println("TextException Exception occurs");
        }
        System.out.println("rest of the code");
    }
}

class TextException extends RuntimeException{

    public TextException(String message) {
        super(message);
    }
}
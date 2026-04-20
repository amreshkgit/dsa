package interviewProgramming;

public class RecursiveReverseString {
    public static void main(String[] args) {
        //int [] array ={1,2,3,};
        String s ="hserma";
        s = StringReverse.recursiveMethod(s);
        System.out.println("Reversed string :: "+s);
    }
}

class StringReverse{

    public static String recursiveMethod(String str)
    {
        if ((null == str) || (str.length() <= 1))
        {
            return str;
        }
        return recursiveMethod(str.substring(1)) + str.charAt(0);
    }
}

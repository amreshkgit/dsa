package lovebabbar.string;

public class PrintAllSubsequence {
    public static void main(String[] args) {

    }
    private static void permutationFind(String input, String output) {
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        String out1 = output;
        String out2 = output;
        out2 += input.charAt(0);
        input = input.substring(1);

        permutationFind(input,out1);
        permutationFind(input,out2);
    }
}

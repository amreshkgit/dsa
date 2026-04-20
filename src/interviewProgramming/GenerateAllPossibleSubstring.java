package interviewProgramming;

public class GenerateAllPossibleSubstring {
    // Function to print all substring
    public static void SubString(String str, int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }

    public static void main(String[] args)
    {
        String str = "abcdf";
        SubString(str, str.length());
    }
}

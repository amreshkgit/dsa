package DynamicProgramming;


//Top down approach
public class LongestCommonSubsequenceTopDown {
    static int[][] t;
    public static void main(String[] args) {
        String s1 = "mokkori";
        String s2 = "irokkom";
        t = new int[s1.length()+1][s2.length()+1];
        int lcs = lcs(s1,s2,s1.length(),s2.length());
        System.out.println("Longest common sequence :: "+lcs);
        String str = printSubsequence(s1,s2,t,s1.length(),s2.length());
        System.out.println(str);
    }

    public static int lcs(String s1 , String s2 ,int firsLen , int secondLen){
        for(int i=1 ; i<firsLen+1;i++){
            for(int j = 1; j<secondLen+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[firsLen][secondLen];
    }

    public static String printSubsequence(String s1, String s2,int[][] t,int i, int j){
        StringBuffer buffer = new StringBuffer();
        while( i> 0 && j>0){ // if any of the string become less then zero
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                buffer.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i][j-1] > t[i-1][j]){
                    j--;
                }else
                    i--;
            }
        }
        return buffer.reverse().toString();
    }
}
//it's first row and column is initialize with 0 so, we to start with (1,1),
//Since it took int array so it first row and column is already initialize with 0.
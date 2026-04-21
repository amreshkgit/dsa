package lovebabbar.array;

public class PlaindromicSubString {
    public static void main(String[] args) {
        String s ="abc";
        System.out.println(countSubString(s));
    }

    public static int countSubString(String s){
        int count = 0;

        for(int i=0; i<s.length(); i++){
            //count odd length plaindromic substring
            count += countPlaindromics(s,i,i);

            //count even length plaindromic substring
            count += countPlaindromics(s,i,i+1);
        }
        return count;
    }
    private static int countPlaindromics(String s, int left, int right) {
        int count =0;
        //check for plaindrom
        while (left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left --;
            right++;
        }
        return count;
    }
}

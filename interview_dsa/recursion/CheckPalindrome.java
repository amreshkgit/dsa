package recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "abade";
        System.out.println(isPalindrome(s, 0, 4));
    }

    /**
     * Take index of first element and last element as l and r
     * then we compare char at l index and r index if it is equal or not equal.
     * @param s
     * @param l
     * @param r
     * @return
     */
    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        } else if (s.charAt(l) != s.charAt(r)) {
            return false;
        }
        return isPalindrome(s, l + 1, r - 1);
    }
}

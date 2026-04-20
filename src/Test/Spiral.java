package Test;

import java.util.Scanner;

/**
 *     0
 *    111
 *   00000
 *  1111111
 * 000000000
 *  1111111
 *   00000
 *    111
 *     0
 */
public class Spiral {
    public static void main(String[] args) {
        int n, i, j, space = 1;
        //System.out.print("Enter the number of rows: ");
        Scanner s = new Scanner(System.in);
        String sc = s.next();
        if(sc.contains("01")){}
        //int flag = 0;
        n = 5;
        space = n - 1;
        for (j = 1; j <= n; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2 * j - 1; i++)
            {
                if(j %2 != 0){
                    System.out.print("0");
                }
                else{
                    System.out.print("1");
                }
            }
            System.out.println("");

        }
        space = 1;
        for (j = 1; j <= n - 1; j++)
        {
            for (i = 1; i <= space; i++)
            {
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * (n - j) - 1; i++)
            {
                if(j %2 == 0) {
                    System.out.print("0");
                }else{
                    System.out.print("1");
                }
            }
            System.out.println("");
        }
    }
}


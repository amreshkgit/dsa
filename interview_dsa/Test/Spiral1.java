package Test;

public class Spiral1 {
    public static void main(String[] args) {
        int n, i, j, space = 1;
        //System.out.print("Enter the number of rows: ");
        //Scanner s = new Scanner(System.in);
       // s.next();
        //int flag = 0;
        n = 2;
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
                System.out.print("z");
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
                System.out.print("z");
            }
            System.out.println("");
        }
    }
}
package lovebabbar.backtracking;

import java.util.ArrayList;

/**
 * The valid moves are:
 *
 * Go Top: (x, y) ——> (x – 1, y)
 * Go Left: (x, y) ——> (x, y – 1)
 * Go Down: (x, y) ——> (x + 1, y)
 * Go Right: (x, y) ——> (x, y + 1)
 *
 * Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
 *
 * Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
 */
public class RatInMaze {
    public static void main(String[] args) {

        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        RatInMaze obj = new RatInMaze();
        ArrayList< String > res = obj.findPath(a);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static void solve(int r, int c, int mat[][], ArrayList < String > ans, String move) {
        int n = mat.length;
        //boundary condition
        if(r<0 || c<0 || r>=n || c>=n || mat[r][c]==0  || mat[r][c] ==-1){
            return;
        }

        if (r == n - 1 && c == n - 1) {
            ans.add(move);
            return;
        }
        mat[r][c] = -1;
        // downward
        solve(r + 1, c, mat, ans, move + 'D');
        //upward
        solve(r - 1, c, mat, ans, move + 'U');
        // left
        solve(r, c - 1, mat, ans, move + 'L');
        // right
        solve(r, c + 1, mat, ans, move + 'R');
        mat[r][c] = 1;
    }
    public static ArrayList < String > findPath(int[][] m) {
        ArrayList < String > ans = new ArrayList < > ();
        if (m[0][0] == 1) solve(0, 0, m, ans, "");
        return ans;
    }


}

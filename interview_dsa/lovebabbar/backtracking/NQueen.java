package lovebabbar.backtracking;

import java.util.Arrays;

/**
 * Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N).
 *
 * Space Complexity: O( N2 )
 */
public class NQueen {
    public static void main(String[] args) {
        // `N × N` chessboard
        int N = 8;

        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] mat = new char[N][N];

        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '–');
        }

        System.out.println(nQueen(mat, 0));
    }

    public static boolean nQueen(char[][] board, int row){
        if(row ==board.length){
            return true;
        }
        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < board.length; i++)
        {
            // if no two queens threaten each other
            if (isSafe(board, row, i))
            {
                // place queen on the current square
                board[row][i] = 'Q';

                // recur for the next row
                if(nQueen(board, row + 1))
                    return true;

                // backtrack and remove the queen from the current square
                board[row][i] = '–';
            }
        }
        return false;
    }

    // Function to check if two queens threaten each other or not
    private static boolean isSafe(char[][] mat, int r, int c)
    {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
        {
            if (mat[i][c] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `\` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

}

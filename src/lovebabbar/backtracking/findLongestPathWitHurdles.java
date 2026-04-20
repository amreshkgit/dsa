package lovebabbar.backtracking;

public class findLongestPathWitHurdles {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };

        System.out.println(findLongestPath(matrix1, 3, 3, 0, 0, 0, 2));

        int[][] matrix2 = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1} };

        System.out.println(findLongestPath(matrix2, 3, 10, 0, 0, 1, 7));
    }

    public static int findLongestPath(int[][] mat, int n, int m,
                                      int row, int col, int rowDest, int colDest) {
        // Base cases

        if (row < 0 || col < 0 || row >= n || col >= m || // invalid coordinate
                mat[row][col] == 2 ||                         // the cell has been visited
                mat[row][col] == 0) {                         // current cell contains an obstacle

            return -1;
        }

        if (row == rowDest && col == colDest) return 0; // the target cell is reached

        // Recursive case

        mat[row][col] = 2; // marking the current cell as visited

        // calling the neighbors
        int right = findLongestPath(mat, n, m, row + 1, col, rowDest, colDest);
        int left = findLongestPath(mat, n, m, row - 1, col, rowDest, colDest);
        int top = findLongestPath(mat, n, m, row, col + 1, rowDest, colDest);
        int bottom = findLongestPath(mat, n, m, row, col - 1, rowDest, colDest);

        mat[row][col] = 1; // restoring the previous value

        int max = Math.max(Math.max(left, right), Math.max(top, bottom));

        return max == -1 ? -1 : max + 1;
    }
}

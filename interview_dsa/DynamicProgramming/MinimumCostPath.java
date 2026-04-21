package DynamicProgramming;

/** Allowed movement
 * (x,y) ---> (x,y+1) right
 *  |
 *  | Down
 *  (x+1,y)
 *  From given either move down or right
 *
 * Will greedy work?
 * Greedy says at given a point we will take most optimal path immediately with knowing about the future
 *  this will give mminimum cost path 9 which not right therefore greedy approach will not work
 *
 * Using recursion ?
 * In order to find minimum path backtracking method says that each an every cell has two option either it
 * can take a path to right or take a path to down so, the recursive approach actually try both of the paths
 * that is all possible path will tried and most optimal will return as an answer. So this will give correct ans
 * for each an every case. In order to apply recursion from a given point will make a call to right hand side
 * we will make call down. so, this way we will get a tree structure, and as soon as we hit the leaf node then that
 * value will return.
 * Time taken by this recursive approach will be 2^n because at each of the cell two option to explore therefore total
 * number of path approximately , it will be equal to 2 to power n. this will not run for larger test case.
 */
// Optimal solution is using dp below
public class MinimumCostPath {
    public static void main(String[] args) {
      int[][] t = new int[][]{{1,3,5},{2,1,2},{4,3,1}};
        System.out.println(findMinCostPath(t)); // answer is 7
    }
    public static int findMinCostPath(int[][]grid){
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        Integer[][] dp  = new Integer[rows][cols];
        int i,j;

        dp[0][0]=grid[0][0]; //1st element is starting point

        //fill the first row
        for(i=1;i<cols;i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];

        }

        //fill the first col
        for(i=1;i<rows;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        //Now fill rest of the cell
        for(i=1;i<rows;i++){
            for(j=1;j<cols;j++) {
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]); //grid[i][j] is current cost on the grid
            }
        }
        return dp[rows-1][cols-1];
    }

    // time complexity is O(n^2)
    // space complexity is O(n^2)
}

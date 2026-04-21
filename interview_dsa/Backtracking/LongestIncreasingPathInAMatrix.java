package Backtracking;

/**
 * #1. From each point , we need to find the longest increasing path
 * #2. Direction allowed : up, down, left and right
 * #3 Condition check : matrix[newX][newY] > matrix[x][y]
 * #4. At each iteration , update the longest increasing path
 */
public class LongestIncreasingPathInAMatrix {
    int [] [] dir ={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {

    }
    public int longestIncreasingPath(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][]mem = new int[row][col];
        int longestPath  =0;
      //Traverse through the matrix
        for(int i =0;i<row;i++){
            for(int j =0; j<col;j++){
                int path =  dfs(matrix,row,col,i,j,mem); //i and j is current position
                longestPath = Math.max(path,longestPath);
            }
        }
        return longestPath;
    }
    public int dfs(int[][] matrix,int row, int col,int i, int j,int[][]mem){
        if (mem[i][j] > 0 )return mem[i][j];
        int max  =0;
        for(int[] dir:dir){
            int x = i+dir[0],y=j+dir[1];// gives new direction
            if (x >=0 && y>=0 && x<row && y<col && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max,dfs(matrix,row,col,x,y,mem));

            }
        }
        mem[i][j] = max+1;
        return max+1;
    }
}

package lovebabbar.matrix;

public class NumberOfIsland {
    public static void main(String[] args) {

    }

    static int numberOfIsland(int[][]grid){
        int rows=grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        //iterate for all cells of the array
        int no_of_island = 0;
        //For loop will iterate each every cell in the matrix
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;++j){
                if(grid[i][j] ==1){ // when current cell is eq to 1 , means we have found new island
                    mark_current_island(grid,i,j,rows,cols);
                    no_of_island += 1;
                }
            }
        }
        return no_of_island;
    }

    private static void mark_current_island(int[][] grid, int i, int j, int rows, int cols) {
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j] != 1){ // boundary case for grid or matrix
            return;
        }
        //mark current cell as visited
        grid[i][j] = 2;

        //Make recursive cell in all 4 adjacent direction
        mark_current_island(grid,i+1,j,rows,cols); //down
        mark_current_island(grid,i,j+1,rows,cols); //right
        mark_current_island(grid,i-1,j,rows,cols); //top
        mark_current_island(grid,i,j-1,rows,cols); //left
    }
}

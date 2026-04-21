package com.interview.graph;

/**
 http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class NumberOfIsland {

    /**
     * Time complexity: O(ROW x COL)
     * Auxiliary Space: O(ROW x COL), due to visited matrix
     * @param graph
     * @return
     */
    public int numberOfIsland(int[][] graph){
        
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        for(int i=0; i < graph.length ; i ++){
            for(int j =0 ; j < graph[i].length ; j++){
                if(!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    DFS(graph,visited,i,j);
                }
            }
        }
        return count;
    }
    
    private void DFS(int[][] graph, boolean[][] visited,int i,int j){
        if(i <0 || j < 0 || i == graph.length || j == graph[i].length)
        {
            return;
            
        }
        visited[i][j] = true;
        if(graph[i][j] == 0){
            return;
        }
        DFS(graph,visited,i,j+1);
        DFS(graph,visited,i+1,j);
        DFS(graph,visited,i+1,j+1);
        DFS(graph,visited,i-1, j+1);
    }

    private int numOfIsland(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int no_of_islands = 0;
        for (int i =0; i<rows;i++){ // this ids processing all the cells
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    mark_current_island(grid,i,j,rows,cols);
                    no_of_islands +=1;
                }
            }
        }
        return no_of_islands;
    }

    //x and y current coordinate of the cell
    // r and c denoting mxn is for our grid
    private void mark_current_island(int[][] grid, int x, int y, int r, int c) {
      if(x<0 || x>=r || y<0 || y>=c || grid[x][y] != 1) //Boundary case for grid
          return;
       //marked current cell as marked
        grid[x][y] = 2;
        //mark recursive call in all 4 adjacent directions
        mark_current_island(grid,x+1,y,r,c);//down
        mark_current_island(grid,x,y+1,r,c); //right
        mark_current_island(grid,x-1,y,r,c); //top
        mark_current_island(grid,x,y-1,r,c); //left
       // DFS(M, i + 1, j + 1, ROW, COL); //upward-right side traversal
        //DFS(M, i - 1, j - 1, ROW, COL); //downward-left side traversal
       //DFS(M, i + 1, j - 1, ROW, COL); //downward-right side traversal
       // DFS(M, i - 1, j + 1, ROW, COL); //upward-left side traversal

    }

    public static void main(String args[]){
        
        int matrix[][] = {{1,1,0,1,0},
                          {1,0,0,1,1},
                          {0,0,0,0,0},
                          {1,0,1,0,1},
                          {1,0,0,0,0}
                        };
        NumberOfIsland island = new NumberOfIsland();
       // int count = island.numberOfIsland(matrix);
        int count = island.numOfIsland(matrix);
        System.out.println(count);
    }
}
                     
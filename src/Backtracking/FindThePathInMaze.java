package Backtracking;

public class FindThePathInMaze {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0},{1,1,0},{0,1,1}};
        int[][] path = new int[3][3];
        findPath(mat,path,3,0,0);

    }

    static boolean findPath(int maze[][],int path[][],int mazeSize,int posX, int posY){

        if(posX < 0 || posX >= mazeSize || posY < 0 || posY >= mazeSize){
           return false;
       }

       if(maze[posX][posY] == 0 || path[posX][posY] == 1){
           return false;
       }

       if(posX == mazeSize-1 && posY == mazeSize-1){
           path[posX][posY] =1;
           for(int i=0;i<=posX;i++){
               for (int j=0;j<=posY;j++){
                   System.out.print(path[i][j]+" ");
               }
               System.out.println(" ");
           }
           return true;
       }

       //since we have consider this on the path mark it 1
       path[posX][posY] = 1;

        //right
        if(findPath(maze,path,mazeSize,posX,posY+1)){
           // path[posX][posY]=0;
            return true;
        }

        //left
        if(findPath(maze,path,mazeSize,posX,posY-1)){
           // path[posX][posY]=0;
            return true;
        }

       //top
       if(findPath(maze,path,mazeSize,posX-1,posY)){
         //  path[posX][posY]=0;
           return true;
       }
       //bottom
        if(findPath(maze,path,mazeSize,posX+1,posY)){
          //  path[posX][posY]=0;
            return true;
        }

        path[posX][posY]=0;
        return false;
    }

}

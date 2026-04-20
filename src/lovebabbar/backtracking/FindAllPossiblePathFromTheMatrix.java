package lovebabbar.backtracking;

import java.util.ArrayList;

//Print all possible paths from top left to bottom right of a mXn matrix
public class FindAllPossiblePathFromTheMatrix {
    public static void main(String[] args) {
        int[][]mat={{1,2,3},
                    {4,5,6}};
        System.out.println(findAllPossiblePaths(2,3,mat));
    }

    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int row,int col, int[][]mat){
        ArrayList<Integer> path = new ArrayList<>(); // store indivual path
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findPaths(0,0,mat,path,ans,row,col);
        return ans;
    }

    private static void findPaths(int i, int j, int[][] mat, ArrayList<Integer> path,
                           ArrayList<ArrayList<Integer>> ans,
                           int row, int col) {

        //check boundary condition
        if (i>=row || j>=col){
            return;
        }
        //This condition to check we have reached to the destination
        if(i==row-1 && j== col-1){
            path.add(mat[i][j]);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(mat[i][j]);
        findPaths(i+1,j,mat,path,ans,row,col); //down
        findPaths(i,j+1,mat,path,ans,row,col); //right
        path.remove(path.size()-1);
    }
}

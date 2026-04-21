package DynamicProgramming;

public class GoldmineProblem {
    public static void main(String[] args) {
     int m =4;
     int n =4;
     int[][] gold ={{1,3,1,5},
                    {2,2,4,1},
                    {5,0,2,3},
                    {0,6,1,2}};
     solve(gold,m,n);
    }
    //
    public static void solve(int[][] gold,int m, int n){
        for(int col = n-2;col>=0;col--){
            for(int row = 0;row < m ;row++){
                int right = gold[row][col+1];
                int right_up = (row==0) ? 0 : gold[row-1][col+1];
                int right_down = (row == m-1) ? 0 : gold[row+1][col+1];
                gold[row][col] = gold[row][col]+Math.max(right,Math.max(right_up,right_down));
            }
        }
        int ans = gold[0][0];
        for(int i=1;i<m;i++){
            ans = Math.max(ans,gold[i][0]);
        }
        System.out.println("Max gold collected: "+ans);
    }
}

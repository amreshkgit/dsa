package lovebabbar.matrix;

/**
 * complexity log(m+n)
 */
public class RowOfMatrixWithMaximumNumberOfOne {
    public static void main(String[] args) {
      int[][] arr = {
              {0,1,1,0},
              {0,0,1,1},
              {1,1,1,1},
              {0,0,0,0}};
        System.out.println(rowWithMax1s(arr,4,4));
    }

    static int rowWithMax1s(int[][] arr, int n,int m){
        int col = m-1;
        int row = -1;
        //Traverse row by row
        for(int i =0; i<n;i++){
            //last column to first
            for(int j =col ;j>=0;j--){
                if(arr[i][j] ==1){ //jb bhi mujhe 1 dikhe on any col
                    row = i;
                    //we will not see same column again
                    col--;
                }
                //if we see zero the skip that row
                else {
                    break;
                }
            }
        }
        return row;
    }
}
/**
 * approch 2 : time complexity n*(logm) n - rows & m - cols
 * mid = low + (high -low)/2
 * if(mid ==1 ){
 *     high = mid -1;
 * }ele{
 *     low = mid+1;
 * }
 * */
package lovebabbar.matrix;

/**
 * Approach to solve :
 *  approach 1:
 *  perform the linear traversal to entire 2D matrix Time complexity O(n*m)
 *  approach 2:
 *  traverse the first row and do the binary search and the go to seco nd row and do the binary search and soon..
 *   Time complexity - (n*log2m)
 *  approach 3 -
 *  place our pointer at last column of first row element and use properties of row wise sorted properties and
 *  columnwise sorted
 *  {10,20,30,40}
 *  {11,21,36,43}
 *  {25,29,39,50}
 *  {50,60,70,80}
 *  here if you will see left side of 40 is less then 40 and bottom of 40 is greater then 40 so move to left means
 *  left of 40 and soon.
 *  ===code===
 *  int i =0 ,j = m-1 // pointer at first row of last column
 *  while( j < n && j >=0 ){
 *      if(mat[i][j] == x) return true;
 *      if(mat[i][j] > x)  j--;
 *      else i++;
 *     }
 */
public class SearchElementInMatrix {
    public static void main(String[] args) {
        int[][] mat ={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
    }

    //using binary search
    public boolean search(int[][]a,int target){
        if(a.length == 0){return false;}
        int row = a.length;
        int col = a[0].length;
        int lo = 0;
        int hi = (row*col)-1;
        while (lo <= hi){
            int mid = (lo+(hi-lo))/2; //binary search
            if(a[mid/col][mid%col] == target){
                return true;
            }
            if(a[mid/col][mid%col] < target){
               lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }
}

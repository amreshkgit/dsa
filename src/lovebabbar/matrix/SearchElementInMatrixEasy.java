package lovebabbar.matrix;

/**
 * complexity o(n+m) because at worst case it can travser upt n row and m column
 * Here idea is to travser from first row last column element i.e. 40 here i our case
 * refer the matrix[][]
 */
public class SearchElementInMatrixEasy {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};
        System.out.println(search(matrix,29));
    }

    public static boolean search(int[][] mat,int key){
        int row = mat.length;
        int col = mat[0].length;
        int i = 0; // first row
        int j = col -1; // this point to first row last column element i.e. 40
        while (i >= 0 && i< row && j>=0 && j<col){
            if(mat[i][j] == key){
                System.out.println("Ele found: "+mat[i][j]);
                return true;
            } else if (mat[i][j] > key) {
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}

package com.interview.multiarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date 03/15/2015 
 * @author Tushar Roy
 * 
 * Given a 2D matrix(square or rectangular) print it in spiral way.
 * e.g 1 2 3
 *     4 5 6
 *     7 8 9 
 * Printing should be 1 2 3 6 9 8 7 4 5    
 *    
 * Solution:
 * Keep 4 pointers which are bounds for this matrix, up, down, left, right. Print each
 * row or column and keep incrementing and decrementing the bounds. As soon as up meets down
 * or left meets right we are done.
 * 
 * Reference
 * https://leetcode.com/problems/spiral-matrix/
 * http://stackoverflow.com/questions/726756/print-two-dimensional-array-in-spiral-order
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class SpiralPrinting {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> result = new ArrayList<>();
        //Left right up and down marking the boundary of our spiral movement
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;

            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }

    public List<Integer> spiralOrderBestApproach(int[][] A) {
        int T,B,L,R,dir;
        T=0;
        B= A.length-1;
        L=0;
        R=A[0].length-1;
        dir=0;
        int i;
        List<Integer> ans = new ArrayList<>();
        while(T<=B && L<=R)
        {
            if(dir==0)
            {
                for(i=L;i<=R;i++)
                    ans.add(A[T][i]);
                T++;
            }
            else if(dir==1)
            {
                for(i=T;i<=B;i++)
                    ans.add(A[i][R]);
                R--;
            }
            else if(dir==2)
            {
                for(i=R;i>=L;i--)
                    ans.add(A[B][i]);
                B--;
            }
            else if(dir==3)
            {
                for(i=B;i>=T;i--)
                    ans.add(A[i][L]);
                L++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
    
    public static void main(String args[]){
        SpiralPrinting sp = new SpiralPrinting();
        int[][] matrix = {{1, 2, 3,4}, { 5 ,   6 ,  7 ,  8},{9 ,10, 11 , 12},{ 13 , 14,  15 , 16}};
        List<Integer> result = sp.spiralOrder(matrix);
        System.out.print(result);
    }


}

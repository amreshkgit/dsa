package lovebabbar.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * In order to solve the problem we will take the 4 pointer
 * 1. top pointer - it will point the first row
 * 2. down pointer - it will point the last row
 * 3. left pointer - it will point the first column
 * 4. right pointer - it will point the last column
 *  it all four pointer are marking the boundary of our spiral movement
 *  Assign top = 0, down = n-1, left = 0, right = n-1
 *  int dir = 0; 0 means left to right
 *  int dir =1; 1 means top to down
 *  int dir =2; 2 means right to left
 *  int dir =3; 3 means bottom to top
 *  while(top < = down && left <= right){
 *      code goes here...
 *  }
 */
public class SpiralTravsersalInMatrix {
    public static void main(String[] args) {
        int[][] mat ={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(spiralOder(mat));
    }

    public static List<Integer> spiralOder(int[][] a){
        int T,B,L,R,dir;
        T=0;
        B= a.length-1;
        L=0;
        R=a[0].length-1;
        dir=0; //DIRECTION POINTER
        int i;
        List<Integer> ans = new ArrayList<>();

        while(T<=B && L<=R)
        {
            if(dir==0)
            {
                for(i=L;i<=R;i++)
                    ans.add(a[T][i]);
                T++;
            }
            //print top to down here column is fixed which is R and row is changing which i
            else if(dir==1)
            {
                for(i=T;i<=B;i++)
                    ans.add(a[i][R]);
                R--; // move right pointer to left
            }
            //Print right to left , here row is fixed and cloumns are changing
            else if(dir==2)
            {
                for(i=R;i>=L;i--)
                    ans.add(a[B][i]);
                B--; //     to shift down pointer to one up
            }
            else if(dir==3)
            {
                for(i=B;i>=T;i--)
                    ans.add(a[i][L]);
                L++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
    }


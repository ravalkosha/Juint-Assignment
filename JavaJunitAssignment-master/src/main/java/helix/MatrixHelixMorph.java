package helix;

import java.util.ArrayList;
import java.util.List;

public class MatrixHelixMorph {

    public static int[][] helix(int[][] matrix) {

        if (matrix.length == 0){
            return null;
        }
        else {
            int M = matrix.length;
            int N = matrix[0].length;

            int mat[][]  = new int[M][N];

            //Converting 2D array to 1D array.
            int count = 0;
            int count2 = 0;

            for (int m = 0; m < matrix.length; m++){
                // Determine length of 2D array
                count += matrix[m].length;
            }

            int [] arr = new int[count];
            // Initialize 1D array

            for (int m = 0; m < matrix.length; m++){

                System.arraycopy (matrix[m], 0, arr, count2, matrix[m].length);
                count2 += matrix[m].length;
            }

            //Filling the matrix in spiral
            int top = 0, bottom = M - 1;
            int left = 0, right = N - 1;
            int index = 0;

            while (true)
            {
                if (left > right) {
                    break;
                }

                // add values to  top row
                for (int i = left; i <= right; i++) {
                    mat[top][i] = arr[index++];
                }
                top++;

                if (top > bottom) {
                    break;
                }

                // add values to right column
                for (int i = top; i <= bottom; i++) {
                    mat[i][right] = arr[index++];
                }
                right--;

                if (left > right) {
                    break;
                }

                // add values to  bottom row
                for (int i = right; i >= left; i--) {
                    mat[bottom][i] = arr[index++];
                }
                bottom--;

                if (top > bottom) {
                    break;
                }

                // add values to  left column
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = arr[index++];
                }
                left++;
            }
            return mat;
        }
    }
}
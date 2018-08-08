// 498 Diagonal Traverse

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
 */

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
            
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n]; // 1D array to store all elements
        int i = 0, j = 0; // 2D index
        boolean bUp = true; // indicate the direction
        for (int k = 0; k < m*n; k++) {
            res[k] = matrix[i][j];
            if (bUp) {
                if (i > 0 && j < n-1 ) {
                    i--; j++;
                } else if (i == 0 && j < n-1) {
                    j++;
                    bUp = false;
                } else if (i < m-1) {
                    i++;
                    bUp = false;
                } else  break;
            } else {
                if (i < m-1 && j > 0) {
                    i++; j--;
                } else if (i < m-1 && j == 0) {
                    i++;
                    bUp = true;
                } else if (j < n-1) {
                    j++;
                    bUp = true;
                } else  break;
            }
        }
        return res;
    }
}

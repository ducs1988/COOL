class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int topOffset = 0;
        int rightOffset = 0;
        int bottomOffset = 0;
        int leftOffset = 0;
        
        int idx = 1;
        
        while (topOffset + bottomOffset < n) {
            // top
            for (int i = leftOffset; i < n-rightOffset; i++) {
                res[topOffset][i] = idx++;
            }
            topOffset++;
            
            // right
            for (int i = topOffset; i < n-bottomOffset; i++) {
                res[i][n-1-rightOffset] = idx++;
            }
            rightOffset++;
            
            // bottom
            for (int i = n-1-rightOffset; i >= leftOffset; i--) {
                res[n-1-bottomOffset][i] = idx++;
            }
            bottomOffset++;
            
            // left
            for (int i = n-1-bottomOffset; i >= topOffset; i--) {
                res[i][leftOffset] = idx++;
            }
            leftOffset++;
        }
        
        return res;
    }
}

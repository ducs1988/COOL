/**
 * Number of Islands
 */

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    remove(grid, i, j);
                }
            }
        }
        return count;
    }

    private void remove(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;

        if (grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        remove(grid, i-1, j);
        remove(grid, i+1, j);
        remove(grid, i, j-1);
        remove(grid, i, j+1);
    }
}

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
 */

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        int R = grid.length, C = grid[0].length;
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    map.put(i*C+j, 0);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int code = loc[0]*C + loc[1];
            for (int[] dir : dirs) {
                int x = loc[0] + dir[0];
                int y = loc[1] + dir[1];
                if (x < 0 || y < 0 || x >= grid.length || 
                    y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0)
                    continue;
                grid[x][y] = 2;
                queue.offer(new int[]{x,y});
                map.put(x*C+y, map.get(code)+1);
                count = map.get(x*C+y);
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return count;
    }
}
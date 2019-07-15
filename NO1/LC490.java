/**
 * 490. The Maze
 * https://leetcode.com/problems/the-maze/
 */

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        dfs(maze, start, visited);
        return visited[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, int[] start, boolean[][] visited) {
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if (visited[x][y] == false) {
                visited[x][y] = true;
                dfs(maze, new int[]{x,y}, visited);
            }
        }
    }
}
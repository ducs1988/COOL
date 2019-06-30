/**
 * 675. Cut Off Trees for Golf Event
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 

You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:

Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
 */

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int cutOffTree(List<List<Integer>> forest) {
        // init collection to store all trees from this area
        List<int[]> trees = new ArrayList();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int val = forest.get(i).get(j);
                if (val > 1)
                    trees.add(new int[]{val, i, j});
            }
        }
        // sort all trees by its height
        Collections.sort(trees, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        // calcute the total distance
        int ans = 0, sr = 0, sc = 0;
        for (int[] tree : trees) {
            int d = dist(forest, sr, sc, tree[1], tree[2]);
            if (d < 0)
                return -1; // cannot reach all trees in this area
            ans += d;
            sr = tree[1];
            sc = tree[2];
        }
        return ans;
    }
    
    private int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc, 0});
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] curt = queue.poll();
            if (curt[0] == tr && curt[1] == tc)
                return curt[2];
            for (int i = 0; i < 4; i++) {
                int r = curt[0] + dr[i];
                int c = curt[1] + dc[i];
                if (0 <= r && r < R && 0 <= c && c < C && !seen[r][c] && forest.get(r).get(c) > 0) {
                    seen[r][c] = true;
                    queue.add(new int[]{r, c, curt[2]+1});
                }
            }
        }
        return -1;
    }
}
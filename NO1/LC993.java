/**
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parents;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parents = new HashMap<>();
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parents.get(x) != parents.get(y);
    }
    
    private void dfs(TreeNode node, TreeNode par) {
        if (node == null)
            return;
        if (par == null)
            depth.put(node.val, 0);
        else
            depth.put(node.val, depth.get(par.val) + 1);
        parents.put(node.val, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
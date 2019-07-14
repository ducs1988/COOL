/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
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
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    
    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        int total = left + right + node.val;
        maxSum = Math.max(maxSum, total);
        return node.val + Math.max(left, right);
    }
}
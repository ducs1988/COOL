/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return lca;
    }
    
    private boolean findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        int left = findLCA(node.left, p, q) ? 1 : 0;
        int right = findLCA(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (left + right + mid >= 2)
            lca = node;
        return (left + right + mid > 0);
    }
}
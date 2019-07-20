/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        TreeNode node = root;
        while (node != null) {
            if (p.val > node.val && q.val > node.val)
                node = node.right;
            else if (p.val < node.val && q.val < node.val)
                node = node.left;
            else
                return node;
        }
        return null;
    }
}
/**
 * 545. Boundary of Binary Tree
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1

Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        if (!isLeaf(root))
            res.add(root.val);
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.val);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
        
        addLeaves(root, res);
        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while (node != null) {
            if (!isLeaf(node))
                stack.push(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }
    
    private void addLeaves(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        if (isLeaf(node))
            list.add(node.val);
        else {
            addLeaves(node.left, list);
            addLeaves(node.right, list);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
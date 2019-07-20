import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Binary Tree Right Side View
 * 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode right = queue.poll();
                if (i == 0) {
                    list.add(right.val);
                }
                if (right.right != null) {
                    queue.add(right.right);
                }
                if (right.left != null) {
                    queue.add(right.left);
                }
            }
        }
        return list;
    }
}

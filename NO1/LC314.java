/**
 * 314. Binary Tree Vertical Order Traversal
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.offer(root);
        level.offer(0);
        while (!queue.isEmpty()) {
            int degree = level.poll();
            TreeNode node = queue.poll();
            
            if (!map.containsKey(degree))
                map.put(degree, new ArrayList<Integer>());
            List<Integer> list = map.get(degree);
            list.add(node.val);
            map.put(degree, list);
            
            if (node.left != null) {
                queue.offer(node.left);
                level.offer(degree-1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                level.offer(degree+1);
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(new ArrayList<Integer>(entry.getValue()));
        }
        return res;
    }
}
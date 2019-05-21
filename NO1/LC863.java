/**
 * All Nodes Distance K in Binary Tree
 * 
 * We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 */

/**
 * 思路
 * As we know, if the distance from a node to target node is k, the distance from its child to the target node is k + 1 unless the child node is closer to the target node which means the target node is in it's subtree.

To avoid this situation, we need to travel the tree first to find the path from root to target, to:

store the value of distance in hashamp from the all nodes in that path to target
Then we can easily use dfs to travel the whole tree. Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node.
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
    Map<TreeNode, Integer> map = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }
    
    private int find(TreeNode root, TreeNode target) {
        if (root == null)
            return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        } 
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left+1);
            return left+1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right+1);
            return right+1;
        }
        return -1;
    } 
    
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }
}
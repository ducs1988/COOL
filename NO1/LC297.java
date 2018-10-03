/**
 * Serialize and Deserialize Binary Tree
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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.left == null)
                sb.append("null,");
            else{
                sb.append(t.left.val).append(",");
                queue.add(t.left);
            }
            if (t.right == null)
                sb.append("null,");
            else {
                sb.append(t.right.val).append(",");
                queue.add(t.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ni = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (!nodes[ni].equals("null")) {
                tmp.left = new TreeNode(Integer.valueOf(nodes[ni]));
                queue.add(tmp.left);
            }
            ni++;
            if (!nodes[ni].equals("null")) {
                tmp.right = new TreeNode(Integer.valueOf(nodes[ni]));
                queue.add(tmp.right);
            }
            ni++;
        }
        return root;
    }
}

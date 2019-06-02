/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node dummy = new Node();
        Node pre = dummy;
        Node node = root;
        while (node != null) {
            if (node.left != null) {
                pre.next = node.left;
                pre = pre.next;
            }
            if (node.right != null) {
                pre.next = node.right;
                pre = pre.next;
            }
            node = node.next;
            if (node == null) {
                pre = dummy;
                node = dummy.next;
                dummy.next = null;
            }
        }
        return root;
    }
}
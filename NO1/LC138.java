/**
 * Copy List with Random Pointer
 */

 /**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)   return head;

        RandomListNode p = head;
        while (p != null) {
            // copy pointer next
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        RandomListNode newHead = p.next;
        while (p != null) {
            RandomListNode oldNext = p.next.next;
            RandomListNode node = p.next;
            p.next = oldNext;
            node.next = oldNext == null ? null : oldNext.next;
            p = p.next;
        }

        return newHead;
    }
}
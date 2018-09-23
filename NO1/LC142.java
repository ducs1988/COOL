/**
 * Linked List Cycle II
 */

 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

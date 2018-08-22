/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)   return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curt = dummy;
        for (int i = 0; i < n; i++) {
            curt = curt.next;
            if (curt == null)   return null;
        }
        
        ListNode prev = dummy;
        while (curt.next != null) {
            prev = prev.next;
            curt = curt.next;
        }
        ListNode next = prev.next.next;
        prev.next = next;
        return dummy.next;
    }
}

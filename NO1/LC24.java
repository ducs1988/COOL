/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	public ListNode swapNodePairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null || head.next.next != null) {
			ListNode n1 = head.next;
			ListNode n2 = head.next.next;
			ListNode post = n2.next;
			head.next = n2;
			n2.next = n1;
			n1.next = post;
			head = n1;
		}

		return dummy.next;
	}
}

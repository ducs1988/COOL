/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
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
 	public ListNode reverseKGroup(ListNode head, int k) {
 		ListNode dummy = new ListNode(0);
 		dummy.next = head;
 		head = dummy;

 		while (head.next != null) {
 			head = reverseNextK(head, k);
 		}

 		return dummy.next;
 	}

 	public ListNode reverseNextK(ListNode node, int k) {
 		ListNode next = node;
 		for (int i = 0; i < k; i++) {
 			if (node.next == null)	return node;
 			next = next.next;
 		}

 		ListNode tail = node.next;
 		ListNode curt = node.next;
 		ListNode prev = null;
 		for (int i = 0; i < k; i++) {
 			ListNode tmp = curt.next;
 			curt.next = prev;
 			prev = curt;
 			curt = tmp;
 		}
 		node.next = prev;
 		tail.next = curt;
 		return tail;
 	}
 }
 
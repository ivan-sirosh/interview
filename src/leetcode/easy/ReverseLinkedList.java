package leetcode.easy;

import leetcode.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * 
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 */

public class ReverseLinkedList {
  static ListNode reverseListRecursive(ListNode current) {

    if (current == null || current.next == null) {
      return current;
    }

    ListNode newHead = reverseListRecursive(current.next);

    current.next.next = current;
    current.next = null;

    return newHead;
  }

  static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {

      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

  public static void main(String[] args) {
    System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
  }

}

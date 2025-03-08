package leetcode.easy;

import leetcode.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a
 * 
 * or false otherwise.
 * Example 1:
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
  public static boolean isPalindrome(ListNode head) {
    if (head != null) {
      if (head.next == null) {
        return true;
      }
    }

    ListNode middle = middle(head);
    ListNode reverse = reverse(middle);

    ListNode first = head;

    while (reverse != null) {
      if (first.val != reverse.val) {
        return false;
      }

      reverse = reverse.next;
      first = first.next;
    }

    return true;

  }

  public static ListNode middle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(1);
    head.next.next.next.next = new ListNode(1);

    System.out.println(isPalindrome(head));
  }
}

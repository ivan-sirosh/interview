package leetcode.easy;

import leetcode.ListNode;

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
    System.out.println(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
  }

}

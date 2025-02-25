package cci.linkedlists;

import cci.ListNode;

public class DeleteMiddleNode {

  static ListNode deleteMiddle(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = slow.next;

    return head;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    System.out.println(deleteMiddle(head));
  }
}

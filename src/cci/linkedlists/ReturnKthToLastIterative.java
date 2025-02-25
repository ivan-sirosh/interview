package cci.linkedlists;

import cci.ListNode;

/**
 * return `K` th to the last element, (iterator from the end of the list)
 * 
 * k = 1 (return last element)
 * k = 2 (return second to the last element)
 * k = 0 (no elemnts)
 */
public class ReturnKthToLastIterative {

  // complexity O(n)
  // space O(1)
  static ListNode kThToLast(ListNode head, int k) {
    ListNode pointer1 = head;
    ListNode pointer2 = head;

    for (int i = 0; i < k; i++) {
      if (pointer1 == null) {
        return null; // Out of bound
      }
      pointer1 = pointer1.next;
    }

    while (pointer1 != null) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return pointer2;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    System.out.println(kThToLast(head, 2));
  }
}

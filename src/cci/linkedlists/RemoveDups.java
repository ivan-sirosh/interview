package cci.linkedlists;

import java.util.HashSet;
import java.util.Set;

import cci.ListNode;

/**
 * Write code to remove duplicates from linked list
 */
public class RemoveDups {

  // complexity O(n)
  // space O(n)
  static ListNode removeDups(ListNode head) {

    Set<Integer> buffer = new HashSet<>();

    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      if (buffer.contains(current.data)) {
        prev.next = current.next;
      } else {
        buffer.add(current.data);
        prev = current;
      }
      current = current.next;
    }

    return head;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode('F');
    head.next = new ListNode('O');
    head.next.next = new ListNode('L');
    head.next.next.next = new ListNode('L');
    head.next.next.next.next = new ListNode('O');
    head.next.next.next.next.next = new ListNode('W');
    head.next.next.next.next.next.next = new ListNode('U');
    head.next.next.next.next.next.next.next = new ListNode('P');

    System.out.println(removeDups(head));
  }
}

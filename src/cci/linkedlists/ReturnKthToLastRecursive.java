package cci.linkedlists;

import cci.ListNode;

/**
 * return `K` th to the last element, (iterator from the end of the list)
 * 
 * k = 1 (return last element)
 * k = 2 (return second to the last element)
 * k = 0 (no elemnts)
 */
public class ReturnKthToLastRecursive {

  static class IndexWrapper {
    int value = 0;
  }

  // complexity O(n)
  // space O(n) - because of recursion
  static ListNode kThToLast(ListNode head, int k) {

    IndexWrapper index = new IndexWrapper();

    return kThToLast(head, k, index);
  }

  static ListNode kThToLast(ListNode head, int k, IndexWrapper index) {
    if (head == null) {
      return null;
    }

    ListNode node = kThToLast(head.next, k, index);
    index.value = index.value + 1;

    if (index.value == k) {
      return head;
    }

    return node;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    System.out.println(kThToLast(head, 0));
  }

}

package cci.linkedlists;

import cci.ListNode;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x
 * 
 */
public class Partition {

  private static ListNode partition(ListNode node, int x) {
    ListNode head = null;
    ListNode left = null;
    ListNode tail = null;
    ListNode right = null;

    while (node != null) {
      ListNode next = node.next;

      if (node.data < x) {
        if(left == null){
          left = node;
          head = left;
        } else {
          left.next = node;
          left = left.next;
        }
      } else {
        if(right == null){
          right = node;
          tail = right;
        } else {
          right.next = node;
          right = right.next;
        }
      }

      node = next;
    }

    right.next = null; // reset latest element, it could be the link in the middle

    if(head == null){
      return tail;
    }

    left.next = tail;

    return head;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(3);
    head.next = new ListNode(5);
    head.next.next = new ListNode(8);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(2);
    head.next.next.next.next.next.next = new ListNode(1);

    System.out.println(partition(head, 5));
  }

}

package cci.linkedlists;

import cci.ListNode;

public class LoopDetection {
  static ListNode getLoopedNode(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    // x+y=2⋅(x+y)2​
    // x+y=x+y
    // Step 1: Detect if a loop exists, fast and slow always meets, but cycle could
    // happend many times before it happens
    while (fast != null && fast.next != null) {
      slow = slow.next; // Move slow by 1
      fast = fast.next.next; // Move fast by 2

      // If they meet, there is a loop
      if (slow == fast) {
        break;
      }
    }

    // If no loop exists
    if (fast == null || fast.next == null) {
      return null;
    }

    // x+(y−x)=y
    // x=y
    // Step 2: Find the start of the loop, from the point where they met it is the
    // same distance to collided node as well as from very start of the list
    slow = head; // Move slow to the head
    while (slow != fast) {
      slow = slow.next; // Move slow by 1
      fast = fast.next; // Move fast by 1
    }

    // Both pointers meet at the start of the loop
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode('A');
    head.next = new ListNode('B');
    head.next.next = new ListNode('C');
    head.next.next.next = new ListNode('D');
    head.next.next.next.next = new ListNode('E');
    head.next.next.next.next.next = head.next.next.next.next;

    System.out.println((char) getLoopedNode(head).data);
    System.out.println(getLoopedNode(null));
  }
}

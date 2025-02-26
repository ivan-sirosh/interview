package cci.linkedlists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import cci.ListNode;

public class Palindrome {

  static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    ListNode middle = null;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // has ODD numbrs in the list, so skip middle
    if (fast != null) {
      slow = slow.next;
    }

    ListNode reversed = reverse(slow);

    while (reversed != null) {
      if (reversed.data != head.data) {
        return false;
      }

      reversed = reversed.next;
      head = head.next;
    }

    return true;

  }

  static ListNode reverse(ListNode head) {
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

    ListNode head = new ListNode(0);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(1);
    head.next.next.next.next.next = new ListNode(0);

    System.out.println(isPalindrome(head));
  }

}

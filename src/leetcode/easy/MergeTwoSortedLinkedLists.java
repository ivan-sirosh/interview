package leetcode.easy;

import leetcode.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * 
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * 
 * 
 */

public class MergeTwoSortedLinkedLists {

  static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    ListNode node1 = list1;
    ListNode node2 = list2;

    LinkedList result = new LinkedList();
    ListNode current;

    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        current = node1;
        node1 = node1.next;
      } else {
        current = node2;
        node2 = node2.next;
      }

      result.add(current);
    }

    if (node1 != null) {
      result.add(node1);
    }

    if (node2 != null) {
      result.add(node2);
    }

    return result.head;

  }

  static class LinkedList {
    ListNode head;
    ListNode tail;
    int size = 0;

    void add(ListNode node) {
      if (size == 0) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
      size++;
    }

  }

  public static void main(String[] args) {
    System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(3))),
        new ListNode(1, new ListNode(3, new ListNode(4)))));
  }
}

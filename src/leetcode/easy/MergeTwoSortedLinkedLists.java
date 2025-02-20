package leetcode.easy;

import leetcode.ListNode;

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

    if(node1 !=null) {
      result.add(node1);
    }

    if(node2 !=null) {
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

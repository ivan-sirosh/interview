package cci.linkedlists;

import cci.ListNode;

public class SumLists {

  static ListNode addListsRecursive(ListNode list1, ListNode list2, int value) {
    if (list1 == null && list2 == null) {
      return null;
    }

    ListNode result = new ListNode(value);

    if (list1 != null) {
      result.data = result.data + list1.data;
    }

    if (list2 != null) {
      result.data = result.data + list2.data;
    }

    int carry = 0;

    if (result.data >= 10) {
      result.data = result.data % 10;
      carry = 1;
    }

    if (list1 != null || list2 != null) {
      ListNode next = addListsRecursive(list1 != null ? list1.next : null, list2 != null ? list2.next : null, carry);
      result.next = next;
    }

    return result;
  }

  static ListNode addLists(ListNode list1, ListNode list2) {

    LinkedList result = new LinkedList();

    int value = 0;

    while (list1 != null || list2 != null) {
      if (list1 != null) {
        value = value + list1.data;
        list1 = list1.next;
      }

      if (list2 != null) {
        value = value + list2.data;
        list2 = list2.next;
      }

      if (value >= 10) {
        result.add(new ListNode(value % 10));
        value = 1;
      } else {
        result.add(new ListNode(value));
        value = 0;
      }

    }

    return result.head;
  }

  static class LinkedList {
    ListNode head = null;
    ListNode tail = null;
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

    ListNode list1 = new ListNode(7);
    list1.next = new ListNode(1);
    list1.next.next = new ListNode(6);

    ListNode list2 = new ListNode(5);
    list2.next = new ListNode(9);
    list2.next.next = new ListNode(2);

    System.out.println(list1);
    System.out.println(list2);
    System.out.println(addLists(list1, list2));

  }

}

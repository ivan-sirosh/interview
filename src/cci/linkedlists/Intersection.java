package cci.linkedlists;

import cci.ListNode;

/**
 * Given singly linked lists determine if two lists intersect.
 * Intersection is defined based on `link`, not `value` - node should match
 */
public class Intersection {

  // intersection means that tail must be the same for both nodes, as linked list
  // has only one connection to next node.
  static ListNode findIntesection(ListNode list1, ListNode list2) {
    if (list1 == null || list2 == null) {
      return null;
    }

    LinkedList tailed1 = findTail(list1);
    LinkedList tailed2 = findTail(list2);

    if (tailed1.tail != tailed2.tail) {
      return null;
    }

    if (tailed1.size > tailed2.size) {
      skipKNodes(tailed1, tailed1.size - tailed2.size);
    } else if (tailed1.size < tailed2.size) {
      skipKNodes(tailed2, tailed2.size - tailed1.size);
    }

    while (tailed1.head != null && tailed1.head.next !=null) {
      if(tailed1.head == tailed2.head){
        return tailed1.head;
      }

      tailed1.head = tailed1.head.next;
      tailed2.head = tailed2.head.next;
    }

    return null;
  }

  static void skipKNodes(LinkedList list, int k) {
    int i = 0;
    while (i != k) {
      list.head = list.head.next;
      i++;
    }
  }

  static LinkedList findTail(ListNode node) {
    LinkedList list = new LinkedList();
    while (node != null && node.next != null) {
      list.add(node);
      node = node.next;
    }
    return list;
  }

  static class LinkedList {
    ListNode head;
    ListNode tail;
    int size = 0;

    LinkedList add(ListNode node) {
      if (size == 0) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        tail = node;
      }

      return this;
    }
  }
}

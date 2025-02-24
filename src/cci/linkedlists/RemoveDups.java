package cci.linkedlists;

import java.util.HashSet;
import java.util.Set;
/**
 * Write code to remove duplicates from linked list
 */
public class RemoveDups {

  // complexity O(n)
  // space O(n)
  static Node removeDups(Node head) {

    Set<Character> buffer = new HashSet<>();

    Node prev = null;
    Node current = head;

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

  static class Node {
    Node next = null;
    char data;

    Node(char data) {
      this.data = data;
    }

    Node(char data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return "'" + data + "' -> " + next;
    }
  }

  public static void main(String[] args) {

    Node head = new Node('F');
    head.next = new Node('O');
    head.next.next = new Node('L');
    head.next.next.next = new Node('L');
    head.next.next.next.next = new Node('O');
    head.next.next.next.next.next = new Node('W');
    head.next.next.next.next.next.next = new Node('U');
    head.next.next.next.next.next.next.next = new Node('P');

    System.out.println(removeDups(head));
  }
}

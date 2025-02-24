package cci.linkedlists;

/**
 * return `K` th to the last element, (iterator from the end of the list)
 * 
 * k = 1 (return last element)
 * k = 2 (return second to the last element)
 * k = 0 (no elemnts)
 */
public class ReturnKthToLastIterative {

  // complexity O(n)
  // space O(1)
  static Node kThToLast(Node head, int k) {
    Node pointer1 = head;
    Node pointer2 = head;

    for (int i = 0; i < k; i++) {
      if (pointer1 == null) {
        return null; // Out of bound
      }
      pointer1 = pointer1.next;
    }

    while (pointer1 != null) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return pointer2;
  }

  public static void main(String[] args) {

    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(5);

    System.out.println(kThToLast(head, 2));
  }

  static class Node {
    Node next = null;
    int data;

    Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "'" + data + "' -> " + next;
    }
  }
}

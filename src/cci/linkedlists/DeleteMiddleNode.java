package cci.linkedlists;

public class DeleteMiddleNode {

  static Node deleteMiddle(Node head) {
    if (head == null) {
      return null;
    }

    Node prev = null;
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = slow.next;

    return head;
  }

  public static void main(String[] args) {

    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(5);

    System.out.println(deleteMiddle(head));
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

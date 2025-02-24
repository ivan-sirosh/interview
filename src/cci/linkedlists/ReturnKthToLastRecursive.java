package cci.linkedlists;

/**
 * return `K` th to the last element, (iterator from the end of the list)
 * 
 * k = 1 (return last element)
 * k = 2 (return second to the last element)
 * k = 0 (no elemnts)
 */
public class ReturnKthToLastRecursive {

  static class IndexWrapper {
    int value = 0;
  }

  // complexity O(n)
  // space O(n) - because of recursion
  static Node kThToLast(Node head, int k) {

    IndexWrapper index = new IndexWrapper();

    return kThToLast(head,k, index);
  }

  static Node kThToLast(Node head, int k, IndexWrapper index) {
    if (head == null) {
      return null;
    }

    Node node = kThToLast(head.next, k, index);
    index.value = index.value + 1;

    if(index.value == k){
      return head;
    }

    return node;
  }

  public static void main(String[] args) {

    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(5);

    System.out.println(kThToLast(head, 0));
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

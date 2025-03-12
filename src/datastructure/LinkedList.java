package datastructure;

public class LinkedList {
  public LinkedListNode head;
  public LinkedListNode tail;
  int size = 0;

  public LinkedList(LinkedListNode node) {
    append(node);
  }

  public LinkedList append(LinkedListNode node) {
    if (size == 0) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;

    return this;
  }

  public LinkedList prepend(LinkedListNode node) {
    node.next = this.head;
    this.head = node;
    size++;

    return this;
  }

  public LinkedList reverse() {
    LinkedListNode prev = null;
    LinkedListNode current = head;

    // Update the tail (old head will become new tail)
    tail = head;

    while (current != null) {
      // prv     cur    nxt
      // null    [0] -> [1] -> [2] -> [3] -> null
      // null <- [0]    [1] -> [2] -> [3] -> null
      LinkedListNode next = current.next; // Store next node
      current.next = prev; // Reverse link

      //         prv    cur    nxt
      // null <- [0]    [1] -> [2] -> [3] -> null
      prev = current; // Move prev forward
      current = next; // Move current forward

      // next opertaions will be 
      //         prv    cur    nxt
      // null <- [0]    [1] -> [2] -> [3] -> null
      // null <- [0] <- [1]    [2] -> [3] -> null
      //                prv    cur    nxt
      // null <- [0] <- [1]    [2] -> [3] -> null
    }

    head = prev; // Update head to the new first node
    
    return this;
  }

  public static void main(String[] args) {
    var node0 = new LinkedListNode(0);
    var node1 = new LinkedListNode(1);
    var node2 = new LinkedListNode(2);
    var node3 = new LinkedListNode(3);

    var ll = new LinkedList(node0)
        .append(node1)
        .append(node2)
        .prepend(node3);

    ll.reverse();

    System.out.println(ll);
  }

  @Override
  public String toString() {
    return "LinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
  }

}

package datastructure;

public class LinkedListNode {
  public LinkedListNode next = null;
  public int data;

  public LinkedListNode(int data) {
    this.data = data;
  }

  public LinkedListNode(int data, LinkedListNode next) {
    this.data = data;
    this.next = next;
  }

  @Override
  public String toString() {
    return "'" + data + "' -> " + next;
  }
}

package cci;

public class ListNode {
  public ListNode next = null;
  public int data;

  public ListNode(int data) {
    this.data = data;
  }

  public ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }

  @Override
  public String toString() {
    return "'" + data + "' -> " + next;
  }
}

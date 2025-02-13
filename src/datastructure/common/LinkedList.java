package datastructure.common;

public class LinkedList {

  private Node head = null;
  private Node tail = null;
  private int size = 0;

  LinkedList append(int value) {
    Node newNode = new Node(value);

    if (size == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }

    size++;

    return this;
  }

  LinkedList prepend(int value) {
    Node newNode = new Node(value);

    if(size == 0){
      head = newNode;
      tail = newNode;
    } else {
      head.prev = newNode;
      newNode.next = head;
      head = newNode;
    }

    size++;

    return this;
  }

  Integer poll(){
    Integer result = null;

    if(head != null){
      result  = head.value;
      head = head.next;
      size--;
    }

    return result;
  }

  Integer removeLast(){
    Integer result = null;

    if(tail != null){
      result  = tail.value;
      tail.prev.next = null;
      tail = tail.prev;
      size--;
    }

    return result;
  }


  @Override
  public String toString() {
    return "{ nodes:%s, size:%s}".formatted(this.head, this.size);
  }

  private static class Node {
    final int value;
    Node next = null;
    Node prev = null;

    Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "{ %s: %s}".formatted(value, next);
    }
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.append(11);
    ll.append(22);
    ll.append(33);
    ll.append(44);

    ll.prepend(00);
    ll.prepend(-1);
    ll.append(99);
    System.out.println(ll.toString());

    ll.poll();

    ll.removeLast();

    System.out.println(ll.toString());
  }
}

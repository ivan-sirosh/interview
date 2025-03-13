package datastructure;

public class Queue<T> {

  private Node<T> first;
  private Node<T> last;

  public void add(T item) {
    var node = new Node<>(item);

    if (isEmpty()) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;
  }

  public T remove() {
    if (first == null) {
      throw new RuntimeException("empty queue");
    }

    T data = first.data;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return data;

  }

  public T peek() {
    if (first == null) {
      throw new RuntimeException("empty queue");
    }

    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "'" + data + "' -> " + next;
    }
  }

  @Override
  public String toString() {
    return "Queue [first=" + first + ", last=" + last + "]";
  }

  public static void main(String[] args) {
    var queue = new Queue<Integer>();

    queue.add(0);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    queue.remove();
    queue.remove();

    System.out.println(queue);
    System.out.println(queue.peek());
  }
}

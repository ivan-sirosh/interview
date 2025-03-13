package datastructure;

public class Stack<T> {
  public Node<T> top;

  public T pop() {
    if (top == null) {
      throw new RuntimeException("empty stack");
    }

    T data = top.data;
    top = top.next;
    return data;
  }

  public void push(T item) {
    var top = new Node<>(item);
    top.next = this.top;
    this.top = top;
  }

  public T peek() {
    if (top == null) {
      throw new RuntimeException("empty stack");
    }

    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
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
    return "Stack [top=" + top + "]";
  }

  public static void main(String[] args) {
    var stack = new Stack<Integer>();

    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.pop();
    stack.pop();

    System.out.println(stack);
    System.out.println(stack.peek());
  }

}

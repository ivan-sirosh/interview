package cci.stackqueue;

import java.util.Stack;

public class SortStack {
  static void sort(Stack<Integer> stack) {
    Stack<Integer> buffer = new Stack<>();

    while (!stack.isEmpty()) {
      int tmp = stack.pop();
      while (!buffer.isEmpty() && buffer.peek() > tmp) {
        stack.push(buffer.pop());
      }
      buffer.push(tmp);
    }
    while (!buffer.isEmpty()) {
      stack.push(buffer.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(12);
    stack.push(8);
    stack.push(3);
    stack.push(1);
    stack.push(5);
    stack.push(10);
    stack.push(7);

    sort(stack);

    System.out.println(stack);
  }
}

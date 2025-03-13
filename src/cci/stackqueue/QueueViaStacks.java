package cci.stackqueue;

import java.util.Stack;

/**
 * implement queue by using stacks, the `idea` to make it lazy, only when we get
 * elements
 */

public class QueueViaStacks<T> {

  private Stack<T> oldS = new Stack<>();
  private Stack<T> newS = new Stack<>();

  public int size() {
    return oldS.size() + newS.size();
  }

  public void add(T value) {
    newS.add(value);
  }

  public T peek() {
    shiftStacks();
    return oldS.peek();
  }

  public T pop() {
    shiftStacks();
    return oldS.pop();
  }

  private void shiftStacks() {
    if (oldS.isEmpty()) {
      while (!newS.isEmpty()) {
        oldS.add(newS.pop());
      }
    }
  }
}

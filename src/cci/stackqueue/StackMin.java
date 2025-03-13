package cci.stackqueue;

import datastructure.Stack;

/**
 * The stack which has a minimum value tracking, operations `push`, `pop`, `min`
 * must be O(1) (no iterations)
 */

public class StackMin extends Stack<Integer> {
  private Stack<Integer> minValues;

  public StackMin() {
    minValues = new Stack<>();
  }

  public void push(int value) {
    if (value <= min()) {
      minValues.push(value);
    }

    super.push(value);
  }

  public Integer pop() {
    int value = super.pop();

    if (value == min()) {
      minValues.pop();
    }

    return value;
  }

  public int min() {
    if (minValues.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return minValues.peek();
    }
  }

  public static void main(String[] args) {
    StackMin stack = new StackMin();

    stack.push(5);
    stack.push(6);
    stack.push(3);
    stack.push(7);

    stack.pop();

    System.out.println(stack.min());
    
    stack.pop();

    System.out.println(stack.min());
  }
}

package com.string.calculator;

import java.util.Stack;

public class StackReverser {

  public <T> Stack<T> reverseStack(Stack<T> stack) {
    Stack<T> temp = new Stack<>();

    while (!stack.isEmpty()) {
      var pop = stack.pop();
      temp.add(pop);
    }
    return temp;
  }
}

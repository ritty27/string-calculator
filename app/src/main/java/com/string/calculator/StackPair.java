package com.string.calculator;

import java.util.Stack;

record StackPair(
  Stack<String> numberStack,
  Stack<OperatorSign> operatorSignStack
) {

}

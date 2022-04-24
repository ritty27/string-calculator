package com.string.calculator;


import java.util.List;
import java.util.Stack;

public class InputConvertor {

  // 상태 저장
  private final Stack<String> numberStack = new Stack<>();
  private final Stack<OperatorSign> operatorSignStack = new Stack<>();
  private final NumberPiece numberPiece = new NumberPiece();

  // 행위
  private final OperationSignChecker operationSignChecker = new OperationSignChecker();
  private final Calculator calculator = new Calculator();

  public StackPair toStack(String input) {

    List<Character> chars = input.chars()
      .mapToObj(c -> (char) c)
      .toList();

    for (Character c : chars) {
      if (existHighOperatorSign()) {
        numberStack.add(calculator.calculateOne(numberStack.pop(), numberStack.pop(), operatorSignStack.pop()));
      }

      if (operationSignChecker.isSupportedOperator(c)) {
        operatorSignStack.add(operationSignChecker.getOperator(c));
      }

      if (canAddNumberToCollection(c)) {
        numberStack.add(numberPiece.getNumber());
      }

      if (isNumberPiece(c)) {
        numberPiece.add(c);
      }
    }
    if (numberPiece.hasNumber()) {
      numberStack.add(numberPiece.getNumber());
    }

    if (existHighOperatorSign()) {
      numberStack.add(calculator.calculateOne(numberStack.pop(), numberStack.pop(), operatorSignStack.pop()));
    }

    return new StackPair(numberStack, operatorSignStack);
  }

  private boolean isNumberPiece(Character c) {
    return c >= '0' && c <= '9';
  }


  private boolean existHighOperatorSign() {
    if (operatorSignStack.isEmpty()) {
      return false;
    }

    // 빠져야 하는 코드인데 현재 코드를 고치면 안됨...
    if (operatorSignStack.size() >= numberStack.size()) {
      return false;
    }

    OperatorSign lastOperator = operatorSignStack.peek();
    return lastOperator == OperatorSign.divide || lastOperator == OperatorSign.multiply;
  }

  private boolean canAddNumberToCollection(char c) {
    return c == ' ' && numberPiece.hasNumber();
  }


}


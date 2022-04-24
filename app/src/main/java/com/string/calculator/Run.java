package com.string.calculator;

import java.util.List;
import java.util.Stack;

/**
 * 얘는 딱 인풋을 받으면 숫자들은 숫자 스택에, 연산자는 연산자스택에 넣어주는 역할만 하고싶은데 <-- 이것도 책임이 많은편인건가 내가 설계한 계산기 특성상 높은 우선순위의
 * 연산자가 있으면 연산을 해줘야 하는 상황....
 */
public class Run {

  //상태
  private Stack<String> numberStack = new Stack<>();
  private Stack<OperatorSign> operatorSignStack = new Stack<>();

  private final NumberPiece numberPiece = new NumberPiece();

  //행위
  private final OperationSignChecker operationSignChecker = new OperationSignChecker();
  private final Calculator calculator;

  public Run() {
    this.calculator = new Calculator();
  }

  public String calculate(String input) {
    List<Character> chars = input.chars()
      .mapToObj(c -> (char) c)
      .toList();

    for (Character c : chars) {
      execute(c);
    }
    checkLast();
    return calculator.calculateAll(numberStack, operatorSignStack);
  }

  private void checkLast() {
    if (numberPiece.hasNumber()) {
      numberStack.add(numberPiece.getNumber());
    }

    if (existHighOperatorSign()) {
      numberStack.add(calculator.calculateOne(numberStack.pop(), numberStack.pop(), operatorSignStack.pop()));
    }
  }


  private void execute(Character c) {
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

  private boolean isNumberPiece(Character c) {
    return c >= '0' && c <= '9';
  }

  private void addNumber() {
    String leftValue = numberStack.pop();
    String rightValue = numberStack.pop();
    OperatorSign operatorSign = operatorSignStack.pop();

    String result = calculator.calculateOne(leftValue, rightValue, operatorSign);
    numberStack.add(result);
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

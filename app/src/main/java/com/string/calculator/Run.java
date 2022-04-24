package com.string.calculator;

import java.util.List;
import java.util.Stack;

/**
 * 얘는 딱 인풋을 받으면 숫자들은 숫자 스택에, 연산자는 연산자스택에 넣어주는 역할만 하고싶은데 <-- 이것도 책임이 많은편인건가 내가 설계한 계산기 특성상 높은 우선순위의
 * 연산자가 있으면 연산을 해줘야 하는 상황....
 */
public class Run {

  //행위
  private final InputConvertor inputConvertor = new InputConvertor();
  private final Calculator calculator = new Calculator();

  public String calculate(String input) {
    StackPair stackPair = inputConvertor.toStack(input);

    Stack<String> numberStack = stackPair.numberStack();
    Stack<OperatorSign> operatorSignStack = stackPair.operatorSignStack();

    return calculator.calculateAll(numberStack, operatorSignStack);
  }

}

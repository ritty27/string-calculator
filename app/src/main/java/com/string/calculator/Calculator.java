package com.string.calculator;

import com.string.calculator.calculate.ArithmeticOperation;
import com.string.calculator.calculate.OperationFactory;

import java.util.Stack;


public class Calculator {

  private final OperationFactory operationFactory = new OperationFactory();
  private final StackReverser stackReverser = new StackReverser();


  public String calculateAll(Stack<String> numberStack, Stack<OperatorSign> operatorSignStack){
    numberStack = stackReverser.reverseStack(numberStack);
    operatorSignStack = stackReverser.reverseStack(operatorSignStack);

    while (numberStack.size() > 1) {
      OperatorSign nowOperationSign = operatorSignStack.pop();
      numberStack.add(calculateOne(numberStack.pop(), numberStack.pop(),nowOperationSign ));
    }

    return numberStack.pop();
  }

  public String calculateOne(String leftValue, String rightValue, OperatorSign operatorSign) {
    // 객체 생성을 동적으로 해야하는 경우
    ArithmeticOperation operation = operationFactory.create(leftValue, rightValue);

    return operation.calculateOne(operatorSign);
  }

}

package com.string.calculator;

import com.string.calculator.calculate.ArithmeticOperation;
import com.string.calculator.calculate.OperationFactory;


public class Calculator {

  private final OperationFactory operationFactory = new OperationFactory();

  public String calculateOne(String leftValue, String rightValue, OperatorSign operatorSign) {
    // 객체 생성을 동적으로 해야하는 경우
    ArithmeticOperation operation = operationFactory.create(leftValue, rightValue);

    return operation.calculateOne(operatorSign);
  }

}

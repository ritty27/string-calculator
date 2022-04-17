package com.string.calculator.calculate;

import static java.lang.Math.multiplyExact;

public class OperationFactory {

  private ArithmeticOperation  primitiveOperation = new PrimitiveOperation();
  private ArithmeticOperation  bigIntegerOperation = new BigIntegerOperation();

  public ArithmeticOperation create(String leftValue, String rightValue) {
    if (isPrimitive(leftValue, rightValue)) {
      return primitiveOperation;
    }
    return bigIntegerOperation;
  }

  private boolean isPrimitive(String leftValue, String rightValue) {
    try {
      multiplyExact(Long.parseLong(leftValue), Long.parseLong(rightValue));
      return true;
    } catch (ArithmeticException | NumberFormatException e) {
      return false;
    }
  }
}

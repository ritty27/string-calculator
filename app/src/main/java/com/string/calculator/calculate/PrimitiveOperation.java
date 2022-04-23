package com.string.calculator.calculate;

public class PrimitiveOperation implements ArithmeticOperation {

  private final long left;
  private final long right;

  public PrimitiveOperation(String leftValue, String rigthValue) {
    this.left = Long.parseLong(leftValue);
    this.right = Long.parseLong(rigthValue);
  }


  @Override
  public String add() {
    return Long.toString(left + right);
  }

  @Override
  public String subtract() {
      return Long.toString(left - right);
    }

  @Override
  public String multiply() {
    return Long.toString(left * right);
  }

}

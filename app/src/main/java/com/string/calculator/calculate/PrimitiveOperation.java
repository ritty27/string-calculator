package com.string.calculator.calculate;

public class PrimitiveOperation implements ArithmeticOperation {

  @Override
  public String add(String leftValue, String rightValue) {
    return Long.toString(Long.parseLong(leftValue) + Long.parseLong(rightValue));
  }

  @Override
  public String subtract(String leftValue, String rightValue) {
    return Long.toString(Long.parseLong(leftValue) - Long.parseLong(rightValue));
  }

  @Override
  public String multiply(String leftValue, String rightValue) {
    return Long.toString(Long.parseLong(leftValue) * Long.parseLong(rightValue));
  }

}

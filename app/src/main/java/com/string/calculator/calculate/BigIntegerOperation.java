package com.string.calculator.calculate;

import java.math.BigInteger;

public class BigIntegerOperation implements ArithmeticOperation {


  @Override
  public String add(String leftValue, String rightValue) {
    BigInteger left = new BigInteger(leftValue);
    BigInteger right = new BigInteger(rightValue);
    return left.add(right).toString();
  }

  @Override
  public String subtract(String leftValue, String rightValue) {
    BigInteger left = new BigInteger(leftValue);
    BigInteger right = new BigInteger(rightValue);
    return left.subtract(right).toString();
  }

  @Override
  public String multiply(String leftValue, String rightValue) {
    BigInteger left = new BigInteger(leftValue);
    BigInteger right = new BigInteger(rightValue);
    return left.multiply(right).toString();
  }

  public BigIntegerOperation() {
  }
}

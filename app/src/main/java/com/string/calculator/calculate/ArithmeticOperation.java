package com.string.calculator.calculate;

import com.string.calculator.OperatorSign;

public interface ArithmeticOperation {

  String add(String leftValue, String rightValue);

  String subtract(String leftValue, String rightValue);

  String multiply(String leftValue, String rightValue);

  default String calculateOne(String leftValue, String rightValue, OperatorSign operator) {
    String result = null;
    switch (operator) {
      case plus -> result = add(leftValue, rightValue);
      case subtract -> result = subtract(leftValue, rightValue);
      case multiply -> result = multiply(leftValue, rightValue);
    }
    return result;
  }

}

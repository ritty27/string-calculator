package com.string.calculator;


public enum OperatorSign {

  plus('+'),
  subtract('-'),
  divide('/'),
  multiply('*');

  private final char sign;

  OperatorSign(char sign) {
    this.sign = sign;
  }

  public char getSign() {
    return sign;
  }

}

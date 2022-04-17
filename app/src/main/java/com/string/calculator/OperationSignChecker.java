package com.string.calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationSignChecker {

  private final Map<Character, OperatorSign> map = new HashMap<>();

  public OperationSignChecker() {
    for (OperatorSign o : OperatorSign.values()) {
      map.put(o.getSign(), o);
    }
  }

  public boolean isSupportedOperator(char c) {
    return map.containsKey(c);
  }

  public OperatorSign getOperator(char c) {
    return map.get(c);
  }
}

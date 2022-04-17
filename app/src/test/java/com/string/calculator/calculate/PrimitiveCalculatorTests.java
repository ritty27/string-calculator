package com.string.calculator.calculate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("long 타입 내의 정수")
class PrimitiveCalculatorTests {

  ArithmeticOperation calculate;

  @BeforeEach
  void init() {
    calculate = new PrimitiveOperation();
  }

  @Test
  @DisplayName("덧셈")
  void addTest() {
    assertEquals(calculate.add("48937", "487394573"), "487443510");
  }

  @Test
  @DisplayName("뺄셈")
  void subtractTest() {
    assertEquals(calculate.subtract("48937", "487394573"), "-487345636");
  }

  @Test
  @DisplayName("곱셈")
  void multiplyTest() {
    assertEquals(calculate.multiply("48937", "487394573"), "23851628218901");
  }


}
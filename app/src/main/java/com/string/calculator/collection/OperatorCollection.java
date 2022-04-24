//package com.string.calculator.collection;
//
//import com.string.calculator.OperatorSign;
//import java.util.Stack;
//
//public class OperatorCollection {
//
//  private Stack<OperatorSign> operatorSignStack = new Stack<>();
//
//  public void add(OperatorSign operatorSign) {
//    operatorSignStack.add(operatorSign);
//  }
//
//  public OperatorSign peek() {
//    return operatorSignStack.peek();
//  }
//
//  public void reverse() {
//    Stack<OperatorSign> temp = new Stack<>();
//
//    while (!operatorSignStack.isEmpty()) {
//      OperatorSign pop = operatorSignStack.pop();
//      temp.add(pop);
//    }
//    operatorSignStack = temp;
//  }
//
//}

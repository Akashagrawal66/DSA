package stack;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Stack;

/*
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.
Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
Input 1:
A =   ["2", "1", "+", "3", "*"]
Input 2:
A = ["4", "13", "5", "/", "+"]
Output 1:
9
Output 2:
6
*/
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (String str : A) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                evalExp(stack, str);
            } else {
                stack.push(Integer.parseInt(str));
            }
            System.out.println(stack);
        }
        return stack.pop();
    }

    private void evalExp(Stack<Integer> stack, String str) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (str) {
            case "+":
                stack.push((num1 + num2));
                return;
            case "-":
                stack.push((num1 - num2));
                return;
            case "*":
                stack.push((num1 * num2));
                return;
            case "/":
                stack.push((num1 / num2));
                return;
        }
        System.out.println("After: "+stack);
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        String[] arr = {"5","1","2","+","4","*","+","3","-"};
        ArrayList<String> arrayList = new ArrayList<>();
        obj.addToList(arrayList, arr);

        EvaluateExpression obj2 = new EvaluateExpression();
        System.out.println(obj2.evalRPN(arrayList));
    }
}

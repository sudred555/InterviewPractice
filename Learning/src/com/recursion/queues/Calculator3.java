/**
 *
 */
package com.recursion.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sudhe
 */
public class Calculator3 {

    public int calculate(String s) {
        Queue<Character> chars = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            chars.add(ch);
        }
        return calc(chars);
    }

    private static int calc(Queue<Character> chars) {
        char op = '+';
        int value = 0;
        Stack<Integer> values = new Stack<>();

        while (!chars.isEmpty()) {
            char ch = chars.poll();
            if (Character.isDigit(ch)) {
                value = value * 10 + (ch - '0');
            } else if (ch == '(') {
                value = calc(chars);
            }
            if (isOp(ch) || ch == ')' || chars.isEmpty()) {
                if (op == '+') {
                    values.add(value);
                } else if (op == '-') {
                    values.add(-value);
                } else if (op == '*') {
                    values.add(values.pop() * value);
                } else if (op == '/') {
                    values.add(values.pop() / value);
                }

                value = 0;
                op = ch;

                if (ch == ')') {
                    break;
                }
            }
        }

        int result = 0;
        for (Integer val : values) {
            result += val;
        }
        return result;
    }

    private static boolean isOp(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    Calculator3 calc = new Calculator3();
    System.out.println(calc.calculate("1-3*2"));
    }

}

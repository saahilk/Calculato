package com.example.android.calculator;

import android.os.Debug;
import android.util.Log;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Created by Saahil on 23-09-16.
 */
public class EvaluateString {

    public static String evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
//        if(tokens[1]=='+')
//        {
//            return Integer.toString(tokens[0]+tokens[2]);
//        }
        Stack<Double> values = new Stack<>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length;)
        {
            // Current token is a whitespace, skip it
//            if (tokens[i] == ' ')
//                continue;
        //System.out.println(tokens[i]);
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length &&((tokens[i] >= '0' && tokens[i] <= '9'))|(tokens[i]=='.')) {
                    sbuf.append(tokens[i++]);
                    //System.out.println("loop");
                   // Log.i("h", "I");
                }
               // System.out.println(tokens[i]);
                //System.out.println(Integer.parseInt(sbuf.toString()));
                values.push(Double.parseDouble(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
//            else if (tokens[i] == '(')
//                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
//            else if (tokens[i] == ')')
//            {
//                while (ops.peek() != '(')
//                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//                ops.pop();
//            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                // Push current token to 'ops'.
                ops.push(tokens[i]);
                i++;
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        DecimalFormat df = new DecimalFormat("#.######");
        //df.setRoundingMode(RoundingMode.CEILING);
        return (df.format(values.pop()).toString());
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static double applyOp(char op, Double b, Double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0)
                    return a / b;
        }
        return 0;
    }

    public static void main(String[] args)
    {}
}

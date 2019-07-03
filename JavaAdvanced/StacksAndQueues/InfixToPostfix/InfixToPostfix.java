package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        String numberPattern = "\\d|[a-z]";

        Pattern numberP = Pattern.compile(numberPattern);

        ArrayDeque<String> outputque = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String token = input[i];
            Matcher numberM = numberP.matcher(token);

            if (numberM.find()) {
                outputque.offer(token);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(token);
                } else {
                    String lastOperator = operatorStack.peek();

                    switch (token) {
                        case "+":
                        case "-":
                            if (!lastOperator.equals("(")) {
                                outputque.offer(operatorStack.pop());
                            }
                            operatorStack.push(token);
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                outputque.offer(operatorStack.pop());
                            }
                            operatorStack.push(token);
                            break;
                        case "(":
                            operatorStack.push(token);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                outputque.offer(operatorStack.pop());
                            }

                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!outputque.isEmpty()) {
            System.out.print(outputque.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
    }
}
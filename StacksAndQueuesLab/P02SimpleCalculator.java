package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] inputLine = scanner.nextLine().split(" ");

        ArrayDeque <Integer> stackForSum = new ArrayDeque<>();
        ArrayDeque <Integer> stackForSubtraction = new ArrayDeque<>();


        String currentOperator = null;
        int result = 0;
        for (int i = 0; i < inputLine.length; i++) {
           String currentSymbol = inputLine [i];
           if (!currentSymbol.equals("+") && !currentSymbol.equals("-")) {
               int currentDigit = Integer.parseInt(currentSymbol);
               if (currentOperator == null || currentOperator.equals("+")) {
                   stackForSum.push(currentDigit);
               } else {
                   stackForSubtraction.push(currentDigit);
               }
           } else {
                currentOperator = currentSymbol;
           }
        }
        while (!stackForSum.isEmpty()) {
            result = result + stackForSum.pop();
        }
        while (!stackForSubtraction.isEmpty()) {
            result = result - stackForSubtraction.pop();
        }
        System.out.println(result);
    }
}

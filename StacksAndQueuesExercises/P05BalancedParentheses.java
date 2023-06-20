package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        ArrayDeque<Character> closedBrackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openBrackets.push(currentSymbol);
            } else if (currentSymbol == ')'){
                closedBrackets.offer('(');
            } else if (currentSymbol == '}') {
                closedBrackets.offer('{');
            } else if (currentSymbol == ']') {
                closedBrackets.offer('[');
            }
        }
        StringBuilder stringForOpen = new StringBuilder();
        StringBuilder stringForClosed = new StringBuilder();
        while (!openBrackets.isEmpty()) {
            char currentOpen = openBrackets.pop();
            stringForOpen.append(currentOpen);
        }
        while (!closedBrackets.isEmpty()) {
            char currentClosed = closedBrackets.poll();
            stringForClosed.append(currentClosed);
        }
        if (stringForOpen.toString().equals(stringForClosed.toString())) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

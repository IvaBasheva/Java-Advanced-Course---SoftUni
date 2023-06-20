package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < input.length(); index++) {
            char symbol = input.charAt(index);

            if (symbol == '(') {
                stack.push(index);
            } else if (symbol == ')'){
                int startIndex = stack.pop();
                String contents = input.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }
}

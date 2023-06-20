package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque <Long> stack = new ArrayDeque<>();
        long max = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {

            String [] commandLine = scanner.nextLine().split(" ");
            if (commandLine.length > 1) {
                long numberToPush =Long.parseLong(commandLine[1]);
                stack.push(numberToPush);
            } else {
                int command = Integer.parseInt(commandLine[0]);
                if (command == 2) {
                    stack.pop();
                } else {
                  while (!stack.isEmpty()) {
                        long currentNumber = stack.pop();
                        if (currentNumber > max) {
                            max = currentNumber;
                        }
                    }
                    System.out.println(max);
                }
            }
        }
    }
}

package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

       String [] commands = scanner.nextLine().split(" ");
       int [] numbersLine = Arrays
               .stream(scanner.nextLine(). split("\\s+"))
               .mapToInt(Integer::parseInt)
               .toArray();

        ArrayDeque <Integer> stack = new ArrayDeque<>();

        int elementsToPush = Integer.parseInt(commands[0]);
        int elementsToPop = Integer.parseInt(commands[1]);
        int elementToSearch = Integer.parseInt(commands[2]);

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbersLine[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        int min = Integer.MAX_VALUE;
        if (stack.contains(elementToSearch)) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        }
        else {
            for (int i = 0; i < stack.size(); i++) {
                int currentNum = stack.pop();
                if (currentNum < min) {
                    min = currentNum;
                }
            }
            System.out.println(min);
        }
    }
}

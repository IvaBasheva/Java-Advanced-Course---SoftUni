package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] commands = scanner.nextLine().split(" ");
        int [] numbersLine = Arrays
                .stream(scanner.nextLine(). split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int elementsToOffer = Integer.parseInt(commands[0]);
        int elementsToPoll = Integer.parseInt(commands[1]);
        int elementToSearch = Integer.parseInt(commands[2]);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < elementsToOffer; i++) {
            int currentNumber = numbersLine[i];
            queue.offer(currentNumber);
        }
        for (int i = 1; i <= elementsToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            while (!queue.isEmpty()) {
                int numberToCheck = queue.poll();
                if (numberToCheck < min) {
                    min = numberToCheck;
                }
            }
            System.out.println(min);
        }
    }
}

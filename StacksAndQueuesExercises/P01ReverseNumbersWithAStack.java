package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] numbers = scanner.nextLine().split(" ");

        ArrayDeque <Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
           int number = Integer.parseInt(numbers[i]);
            numbersStack.push(number);
        }
        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }
    }
}

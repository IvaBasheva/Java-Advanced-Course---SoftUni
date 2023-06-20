package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        LinkedHashSet <Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet <Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds -- > 0) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber){
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                System.out.println("Draw!");
                break;
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}

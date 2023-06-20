package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();


        while (n-- > 0) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNumber);
        }
        while (m-- > 0) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        for (int element : firstSet) {
            if (secondSet.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }

}




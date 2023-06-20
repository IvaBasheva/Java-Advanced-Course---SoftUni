package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] info = scanner.nextLine().split("\\s+");

        Consumer<String> print = name -> System.out.printf("Sir %s%n",name);

        Arrays.stream(info).forEach(print);

    }
}

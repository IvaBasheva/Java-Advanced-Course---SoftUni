package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P04CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate <String> isStartingWithUppercase =
                w -> Character.isUpperCase(w.charAt(0));

        List<String> filterWords = new ArrayList<>();

        Arrays.stream(words)
                .filter(isStartingWithUppercase)
                .forEach(filterWords::add);

        System.out.println(filterWords.size());

        filterWords.forEach(System.out::println);

    }
}

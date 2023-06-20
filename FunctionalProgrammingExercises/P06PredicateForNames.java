package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int filterLength = Integer.parseInt(scanner.nextLine());

        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

       Predicate <String> predicate = name -> name.length() <= filterLength;

       namesList.stream().filter(predicate)
               .forEach(System.out::println);

    }
}

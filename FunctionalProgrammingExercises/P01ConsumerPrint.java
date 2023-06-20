package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String [] info = scanner.nextLine().split("\\s+");

        Consumer <String> print = element -> System.out.println(element);

        Arrays.stream(info).forEach(e -> print.accept(e));
    }
}

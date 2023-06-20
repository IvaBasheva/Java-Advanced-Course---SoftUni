package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class P03AddVAT {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        UnaryOperator <Double> addVat = value -> value * 1.2;

        double [] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");

        Arrays.stream(prices).forEach(price ->
                System.out.printf("%.2f%n", addVat.apply(price)));


    }
}

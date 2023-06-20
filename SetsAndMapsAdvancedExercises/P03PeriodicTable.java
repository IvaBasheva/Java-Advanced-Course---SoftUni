package SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueCompounds = new TreeSet<>();

        while (n-- > 0) {
            String [] chemicalCompounds = scanner.nextLine().split("\\s");

            for (String compound : chemicalCompounds) {
                uniqueCompounds.add(compound);
            }
        }
        for (String comp : uniqueCompounds) {
            System.out.print(comp + " ");
        }

    }
}

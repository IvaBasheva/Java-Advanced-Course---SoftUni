package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String text = scanner.nextLine();
        Map <Character, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (!countSymbols.containsKey(currentChar)) {
                countSymbols.put(currentChar, 1);
            } else {
                countSymbols.put(currentChar, countSymbols.get(currentChar) + 1);
            }

        }
        countSymbols.entrySet().stream().forEach(entry -> {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        });

    }
}

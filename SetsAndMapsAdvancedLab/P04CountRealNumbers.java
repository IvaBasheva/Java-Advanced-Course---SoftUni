package SetsAndMapsAdvancedLab;

import java.util.*;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double :: parseDouble)
                .toArray();
        Map <Double, Integer> map = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        map.entrySet().stream().forEach(e -> {
            System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue());
                });
        }

    }

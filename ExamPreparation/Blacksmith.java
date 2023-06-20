package ExamPreparation;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Map<String, Integer> swords = new TreeMap<>();

        ArrayDeque<Integer> steel = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(steel::offer);

        ArrayDeque<Integer> carbon = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(carbon::push);

        while (!steel.isEmpty() && !carbon.isEmpty()) {

            int currentSteel = steel.peek();
            int currentCarbon = carbon.peek();

            int sumOfSteelAndCarbon = currentSteel + currentCarbon;

            if (sumOfSteelAndCarbon == 70) {
                swords.putIfAbsent("Gladius", 0);
                swords.put("Gladius", swords.get("Gladius") + 1);
                removeSteelAndCarbon(steel,carbon);
            } else if (sumOfSteelAndCarbon == 80) {
                swords.putIfAbsent("Shamshir", 0);
                swords.put("Shamshir", swords.get("Shamshir") + 1);
                removeSteelAndCarbon(steel,carbon);
            } else if (sumOfSteelAndCarbon == 90) {
                swords.putIfAbsent("Katana", 0);
                swords.put("Katana", swords.get("Katana") + 1);
                removeSteelAndCarbon(steel,carbon);
            } else if (sumOfSteelAndCarbon == 110) {
                swords.putIfAbsent("Sabre", 0);
                swords.put("Sabre", swords.get("Sabre") + 1);
                removeSteelAndCarbon(steel,carbon);
            } else {
                removeSteelAndCarbon(steel, carbon);
                currentCarbon += 5;
                carbon.addFirst(currentCarbon);
            }
        }
        if (!swords.isEmpty()) {
            AtomicInteger totalSwords = new AtomicInteger();
            swords.entrySet().forEach(entry -> {
                totalSwords.addAndGet(entry.getValue());
            });
            System.out.printf("You have forged %s swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.println(steel.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbon.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        swords.entrySet().forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }
    public static void removeSteelAndCarbon (ArrayDeque <Integer> steel, ArrayDeque <Integer> carbon) {
        steel.poll();
        carbon.pop();
    }
}

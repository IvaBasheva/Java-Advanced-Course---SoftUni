package Exam;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Map <String, Integer> peaks =  new LinkedHashMap<>();
        List <String> climbedPeaks =  new ArrayList<>();
        boolean allPeaksClimbed = false;

        ArrayDeque<Integer> foodPortions  = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(foodPortions::push);

        ArrayDeque<Integer> stamina = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stamina::offer);

        peaks.put("Vihren", 80);
        peaks.put("Kutelo", 90);
        peaks.put("Banski Suhodol", 100);
        peaks.put("Polezhan", 60);
        peaks.put("Kamenitza", 70);

        while (!foodPortions.isEmpty() && !stamina.isEmpty()) {

            int foodForTheDay = foodPortions.pop();
            int dailyStamina = stamina.poll();
            int sum = foodForTheDay + dailyStamina;

            if (peaks.containsKey("Vihren")) {
                if (sum >= 80) {
                    peaks.remove("Vihren");
                    climbedPeaks.add("Vihren");
                }
            } else if (peaks.containsKey("Kutelo")) {
                if (sum >= 90) {
                    peaks.remove("Kutelo");
                    climbedPeaks.add("Kutelo");
                }
            }
            else if (peaks.containsKey("Banski Suhodol")) {
                if (sum >= 100) {
                    peaks.remove("Banski Suhodol");
                    climbedPeaks.add("Banski Suhodol");
                }
            }
            else if (peaks.containsKey("Polezhan")) {
                if (sum >= 60) {
                    peaks.remove("Polezhan");
                    climbedPeaks.add("Polezhan");
                }
            }
            else if (peaks.containsKey("Kamenitza")) {
                if (sum >= 70) {
                    peaks.remove("Kamenitza");
                    climbedPeaks.add("Kamenitza");
                }
            }
            if (peaks.isEmpty()) {
                allPeaksClimbed = true;
                break;
            }
        }
        if (allPeaksClimbed) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!climbedPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : climbedPeaks) {
                System.out.println(peak);
            }
        }
    }
}

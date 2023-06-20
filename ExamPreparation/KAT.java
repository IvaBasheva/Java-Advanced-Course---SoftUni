package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int registeredCars = 0;
        int days = 0;
        ArrayDeque<Integer> licencePlates = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(licencePlates::offer);

        ArrayDeque<Integer> cars = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(cars::push);

        while (!licencePlates.isEmpty() && !cars.isEmpty()) {
            days++;

            int currentLicencePlates = licencePlates.poll();
            int currentCars = cars.pop();

            if (currentLicencePlates / 2 >= currentCars) {
                registeredCars += currentCars;
                currentLicencePlates -= currentCars * 2;
                if (currentLicencePlates != 0) {
                    licencePlates.add(currentLicencePlates);
                }
            } else {
                registeredCars += currentLicencePlates / 2;
                currentCars = currentCars - currentLicencePlates / 2;
                cars.add(currentCars);
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);
        if (licencePlates.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!licencePlates.isEmpty()) {
            int countOfPlates = 0;
            for (Integer licencePlate : licencePlates) {
                countOfPlates += licencePlate;
            }
            System.out.printf("%d license plates remain!", countOfPlates);
        } else {
            int leftCars = 0;
            for (Integer car : cars) {
                leftCars += car;
            }
            System.out.printf("%d cars remain without license plates!",leftCars);
        }
    }
}

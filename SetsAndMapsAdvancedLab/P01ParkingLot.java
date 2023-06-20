package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String  input = scanner.nextLine();

        Set<String> carsSet = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String [] carInfo = input.split(", ");

            String command = carInfo[0];
            String carNumber = carInfo[1];

            if (command.equals("IN")) {
                carsSet.add(carNumber);
            } else {
                carsSet.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if (carsSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carsSet) {
                System.out.println(carNumber);
            }
        }
    }

}

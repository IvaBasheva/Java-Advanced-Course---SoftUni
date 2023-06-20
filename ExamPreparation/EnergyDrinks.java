package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        ArrayDeque <Integer> milligramsCaffeineStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(milligramsCaffeineStack::push);

        ArrayDeque <Integer> energyDrinksQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinksQueue::offer);

        int drankCaffeine = 0;

        while (!milligramsCaffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {

            int milligrams = milligramsCaffeineStack.peek();
            int energyDrink = energyDrinksQueue.peek();

            int currentCaffeine = milligrams * energyDrink;

            if (drankCaffeine + currentCaffeine <= 300) {
                milligramsCaffeineStack.pop();
                energyDrinksQueue.poll();

                drankCaffeine += currentCaffeine;
            } else  {
                milligramsCaffeineStack.pop();
                int drinkToMove = energyDrinksQueue.poll();
                energyDrinksQueue.add(drinkToMove);

                if (drankCaffeine > 30) {
                    drankCaffeine -= 30;
                }
            }
        }
        if (!energyDrinksQueue.isEmpty()) {
            System.out.print("Drinks left: ");
            String output = energyDrinksQueue.toString().replaceAll("\\[", "")
                    .replaceAll("]", "");
            System.out.println(output);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", drankCaffeine);
    }
}

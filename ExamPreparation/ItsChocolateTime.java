package ExamPreparation;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        Map <String, Integer> producedChocolates = new TreeMap<>();
        ArrayDeque <Double> milkValues = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkValues::offer);

        ArrayDeque <Double> cacaoPowderValues = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoPowderValues::push);

       while (!milkValues.isEmpty() && !cacaoPowderValues.isEmpty()) {

           double milk= milkValues.peek();
           double cacaoPowder = cacaoPowderValues.peek();

           int cacaoPercentage = (int)Math.round((cacaoPowder / (cacaoPowder + milk)) * 100.0);

           producedChocolates.putIfAbsent("Milk Chocolate", 0);
           producedChocolates.putIfAbsent("Dark Chocolate", 0);
           producedChocolates.putIfAbsent("Baking Chocolate", 0);

           if (cacaoPercentage == 30) {
               producedChocolates.put("Milk Chocolate", producedChocolates.get("Milk Chocolate") + 1);
               milkValues.poll();
               cacaoPowderValues.pop();
           } else if (cacaoPercentage == 50) {
               producedChocolates.put("Dark Chocolate", producedChocolates.get("Dark Chocolate") + 1);
               milkValues.poll();
               cacaoPowderValues.pop();
           } else if (cacaoPercentage == 100) {
               producedChocolates.put("Baking Chocolate", producedChocolates.get("Baking Chocolate") + 1);
               milkValues.poll();
               cacaoPowderValues.pop();
           } else {
               cacaoPowderValues.pop();
               double increasedMilk = milk + 10;
               milkValues.poll();
               milkValues.add(increasedMilk);
           }
       }

       if (producedChocolates.containsValue(0)) {
           System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
       } else {
           System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
       }

       producedChocolates.entrySet().stream().forEach(entry -> {
           if (entry.getValue() != 0) {
               System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
           }
       });
    }
}

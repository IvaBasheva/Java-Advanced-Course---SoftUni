package SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();
        Map <String, Set<String>> playersDeck = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String [] playerCards = input.split(": |, ");
            String name =  playerCards [0];
            for (int i = 1; i < playerCards.length; i++) {
                String card = playerCards[i];
                if (!playersDeck.containsKey(name)) {
                    playersDeck.put(name, new LinkedHashSet<>());
                } else {
                    playersDeck.get(name).add(card);
                }
            }

            input = scanner.nextLine();
        }
       playersDeck.entrySet().stream().forEach(entry -> {
           AtomicInteger finalSum = new AtomicInteger();
           entry.getValue().stream().forEach(e -> {
               char secondElement = e.charAt(e.length() - 1);
               int firstNum = 0;
               int secondNum = 0;
               int sum = 0;
               if (e.length() == 2) {
                  char firstElement = e.charAt(0);

                  if (firstElement == '2' || firstElement == '3' || firstElement == '4' || firstElement == '5' ||
                          firstElement == '6' || firstElement == '7' || firstElement == '8' || firstElement == '9') {
                       firstNum = Integer.parseInt(firstElement + "");
                  } else if (firstElement == 'J') {
                      firstNum = 11;
                  } else if (firstElement == 'Q'){
                      firstNum = 12;
                  } else if (firstElement == 'K') {
                      firstNum = 13;
                  } else if (firstElement == 'A') {
                      firstNum = 14;
                  }

               } else if (e.length() == 3) {
                    firstNum = Integer.parseInt(e.substring(0, 2));
               }
               if (secondElement == 'S') {
                   secondNum = 4;
               } else if (secondElement == 'H') {
                   secondNum = 3;
               } else if (secondElement == 'D') {
                   secondNum = 2;
               } else if (secondElement == 'C') {
                   secondNum = 1;
               }
               sum = firstNum * secondNum;
               finalSum.addAndGet(sum);
           });
           System.out.printf("%s: %s%n", entry.getKey(), finalSum.toString());
       });

    }
}

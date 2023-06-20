package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

       String command = scanner.nextLine();
        Map <String, String> phonebook = new HashMap<>();

       while (!command.equals("search")) {
           String [] contact = command.split("-");
           String name = contact[0];
           String number = contact[1];

           phonebook.put(name, number);

           command = scanner.nextLine();
       }
       String nameToFind = scanner.nextLine();
       while (!nameToFind.equals("stop")) {
           if (phonebook.containsKey(nameToFind)) {
               System.out.printf("%s -> %s%n", nameToFind, phonebook.get(nameToFind));
           } else {
               System.out.printf("Contact %s does not exist.%n", nameToFind);
           }

           nameToFind = scanner.nextLine();
       }

    }
}

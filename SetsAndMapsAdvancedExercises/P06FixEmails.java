package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> emailsMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();

            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                emailsMap.put(name, email);
            }
            input = scanner.nextLine();
        }
        emailsMap.entrySet().stream().forEach(entry -> {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        });
    }
}

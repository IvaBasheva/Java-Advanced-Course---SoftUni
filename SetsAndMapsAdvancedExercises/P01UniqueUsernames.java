package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> usernamesSet = new LinkedHashSet<>();

        while (n-- > 0) {
            String username = scanner.nextLine();
            usernamesSet.add(username);
        }

        for (String username : usernamesSet) {
            System.out.println(username);
        }
    }
}

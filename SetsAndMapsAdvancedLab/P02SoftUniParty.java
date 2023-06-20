package SetsAndMapsAdvancedLab;

import java.util.*;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vipGuests = new TreeSet<>();
        Set<String> otherGuests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            char firstSymbol = input.charAt(0);
            if (Character.isDigit(firstSymbol)) {
                vipGuests.add(input);
            } else {
                otherGuests.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("END")) {
            vipGuests.remove(input);
            otherGuests.remove(input);

            input = scanner.nextLine();
        }
        System.out.println(vipGuests.size() + otherGuests.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String otherGuest : otherGuests) {
            System.out.println(otherGuest);
        }

    }

}

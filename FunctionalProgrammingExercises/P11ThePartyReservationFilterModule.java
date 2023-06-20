package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        List<String> quests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String [] commandParts = command.split(";");
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];

            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }

            command = scanner.nextLine();
        }
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            quests.removeIf(filterToApply);
        });
        for (String quest : quests) {
            System.out.print(quest + " ");
        }
    }

    private static Predicate<String> getPredicate(String filter) {
        String [] filterParts = filter.split(";");
        String filterType = filterParts [0];
        String filterParameter = filterParts [1];

        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(filterParameter);
            case "Ends with":
                return s -> s.endsWith(filterParameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return s-> s.contains(filterParameter);
        }
        return null;
    };
}

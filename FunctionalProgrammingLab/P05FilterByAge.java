package FunctionalProgrammingLab;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static class Person {
        String name;
        int age;

        Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List <Person> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String [] information = scanner.nextLine().split(", ");

            String name = information[0];
            int age = Integer.parseInt(information [1]);

            Person person = new Person(name, age);
            people.add(person);

        }
        String condition = scanner.nextLine();
        int filterAge = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate <Person> conditionFilter = getFilter(condition, filterAge);
        Consumer <Person> printer = getPrinter(format);

        people.stream().filter(conditionFilter)
                .forEach(printer);


    }

    private static Consumer<Person> getPrinter(String format) {
        switch (format){
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown print format " + format);
        }
    }

    private static Predicate<Person> getFilter(String condition, int filterAge) {
        switch (condition) {
            case "younger":
                return p-> p.age <= filterAge;
            case "older":
                return p-> p.age >= filterAge;
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }
    }

}
